/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rbary_ftoulouz;

/**
 *
 * @author ftoulouz
 */
public class Annuaire_UPPA {
    static final String _LDAP_UPPA = "ldap://ldap.univ-pau.fr";
    static final String _People_UPPA = "ou=people,dc=univ-pau,dc=fr";
    static java.util.Properties _Properties = new java.util.Properties();
    static javax.naming.directory.InitialDirContext _IDC;
    static java.util.List<String> _People_attributes = null;

    static {
        _Properties.setProperty(javax.naming.Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        _Properties.setProperty(javax.naming.Context.PROVIDER_URL, _LDAP_UPPA);
    }

    public static java.util.List<String> People_attributes() throws javax.naming.NamingException {
        if (_People_attributes == null) {
            _People_attributes = new java.util.ArrayList<String>();
        }
        if (!_People_attributes.isEmpty()) {
            return _People_attributes;
        }
        _IDC = new javax.naming.directory.InitialDirContext(_Properties);
        javax.naming.directory.DirContext dc = (javax.naming.directory.DirContext) _IDC.lookup(_People_UPPA);
        javax.naming.NamingEnumeration<javax.naming.NameClassPair> ne = dc.list("");
        if (ne.hasMore()) {
            javax.naming.directory.Attributes attributes = dc.getAttributes(ne.next().getName());
            javax.naming.NamingEnumeration<String> ids = attributes.getIDs();
            while (ids.hasMore()) {
                _People_attributes.add(ids.next());
            }
        }
        dc.close();
        _IDC.close();

        return _People_attributes;
    }

    public static java.util.List<String> People_attribute_values(java.util.Vector<Request> criteres_) throws javax.naming.NamingException {
        java.util.List<String> result = new java.util.ArrayList<String>();
        java.util.Vector<Request> criteres = new java.util.Vector<Request>(criteres_);

        for (int i = 0; i < criteres.size(); i++) {
            System.out.println("CRITERE" + i + ": " + criteres.get(i).getTotalFilter());
            if (!People_attributes().contains(criteres.get(i).getAttr())) {
                result.add("?");
                return result;
            }
        }



        _IDC = new javax.naming.directory.InitialDirContext(_Properties);

        javax.naming.directory.Attributes attributes = new javax.naming.directory.BasicAttributes(true);
        for (int i = 0; i < criteres.size(); i++) {
            attributes.put(new javax.naming.directory.BasicAttribute(criteres.get(i).getAttr(), criteres.get(i).getValue()));
        }

        System.out.print("AFFICHAGE DU FILTRE: ");
        String filterExp = "";// "(&(!(givenname=fr))(uppaSite~=mont de marsan))";
        filterExp = construction_filtre(criteres);

        System.out.println("FILTER FINAL: " + filterExp + "\n");

        javax.naming.NamingEnumeration<javax.naming.directory.SearchResult> ne = _IDC.search(_People_UPPA, filterExp, null);
        while (ne.hasMore()) {
            result.add(ne.next().getAttributes().toString());
        }
        _IDC.close();

        return result;
    }

    static String construction_filtre2(java.util.Vector<Request> criteres, String f) {
        if (criteres.size() == 0) {
            return f;
        } else {
            String filtretmp = f + criteres.get(0).getTotalFilter();
            String EtOu = criteres.get(0).getStrEtOu();
            criteres.remove(0);
            return EtOu + construction_filtre2(criteres, filtretmp + ")");
        }

    }

    static String construction_filtre(java.util.Vector<Request> criteres) {
        if (criteres.size() == 0) {
            return "";
        } else {
            String filtretmp = criteres.get(0).getTotalFilter();
            String EtOu = criteres.get(0).getStrEtOu();
            criteres.remove(0);
            System.out.println("FILTRE TMP: " + filtretmp);
            return EtOu + construction_filtre2(criteres, filtretmp);
        }
    }

}