/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rbary_ftoulouz;

/**
 *
 * @author ftoulouz
 */
import java.util.List;

public class cherchePersonne {
    private String sortie=new String();


// Traintement de la chaine de tel
private String testTel(String tel){
    String str[]=tel.split(" 0");
    String testtel = "+33 "+str[1];
    return testtel;
}

// Traitement de la chaine de sortie
    private String affichage(String s){
        String affich="";
        String gmail="";
        String gnp="";
        String gciv="";
        String gform="";

        try{
            String str[]=s.split("mail: ");
            String str1[]=str[1].split(", ");
            String mail = str1[0]+" ";
            gmail=mail;
        }catch(ArrayIndexOutOfBoundsException ai) {
            
        }

        try{
            String str2[]=s.split("displayName: ");
            String str3[]=str2[1].split(", ");
            String np = str3[0]+" ";
            gnp=np;
        }catch(ArrayIndexOutOfBoundsException ai) {
            
        }
                
        try{
            String str4[]=s.split("supannCivilite: ");
            String str5[]=str4[1].split(", ");
            String civ = str5[0] +" ";
            gciv=civ;
        }catch(ArrayIndexOutOfBoundsException ai) {
            
        }
        
        try{
            String str6[]=s.split("uppaFormation: ");
            String str7[]=str6[1].split(", ");
            String form = str7[0] +" ";
            gform=form;
        }catch(ArrayIndexOutOfBoundsException ai) {
            
        }

        affich ="* "+gciv + gnp + '\n'+ gmail +'\n'+ gform +'\n'+'\n';

        return affich;
    }

        //recherche personne par Statut et prenom et nom
        public String parPrenomparNomparStatut(String prenompersonne, String nompersonne, String nomstatut){

        //tous les champs sont renseignees
        if(!nompersonne.equals("")&& !prenompersonne.equals("")){
            try{
            java.util.Vector<Request> v = new java.util.Vector<Request>();
            v.add(new Request("true", "sn", "EGAL", nompersonne, "ET"));
            v.add(new Request("true", "givenName", "EGAL", prenompersonne, "ET"));
            v.add(new Request("true", "eduPersonAffiliation", "EGAL",nomstatut, "NULL"));

            java.util.List<String> result = Annuaire_UPPA.People_attribute_values(v);

            sortie ="";
            for (String s : result) {
                sortie += affichage(s);
            }

            }catch (javax.naming.NamingException ne) {
                System.err.println(ne.getMessage() +" " +ne.getExplanation());
            }
        }

        //le champs nom pas renseigne
        if(nompersonne.equals("") && !prenompersonne.equals("")){
        try {
            java.util.Vector<Request> v = new java.util.Vector<Request>();
            v.add(new Request("true", "givenName", "EGAL", prenompersonne, "ET"));
            v.add(new Request("true", "eduPersonAffiliation", "EGAL", nomstatut, "NULL"));

            java.util.List<String> result = Annuaire_UPPA.People_attribute_values(v);

            sortie = "";
            for (String s : result) {
                sortie += affichage(s);
            }
        } catch (javax.naming.NamingException ne) {
            System.err.println(ne.getMessage() +" " +ne.getExplanation());
            }
        }

        //les champs nom et prenom ne sont pas renseignes
        if(nompersonne.equals("") && prenompersonne.equals("") && !nomstatut.equals("")){
        try {
            java.util.Vector<Request> v = new java.util.Vector<Request>();
            v.add(new Request("true", "eduPersonAffiliation", "EGAL", nomstatut, "NULL"));

            java.util.List<String> result = Annuaire_UPPA.People_attribute_values(v);

            sortie = "";
            for (String s : result) {
                sortie += affichage(s);
            }
        } catch (javax.naming.NamingException ne) {
            System.err.println(ne.getMessage() +" " +ne.getExplanation());
            }
        }

        //le champs prenom n'est pas renseigne
        if(!nompersonne.equals("") && prenompersonne.equals("")){
        try {
            java.util.Vector<Request> v = new java.util.Vector<Request>();
            v.add(new Request("true", "sn", "EGAL", nompersonne, "ET"));
            v.add(new Request("true", "eduPersonAffiliation", "EGAL", nomstatut, "NULL"));

            java.util.List<String> result = Annuaire_UPPA.People_attribute_values(v);

            sortie = "";
            for (String s : result) {
                sortie += affichage(s);
            }
        } catch (javax.naming.NamingException ne) {
            System.err.println(ne.getMessage() +" " +ne.getExplanation());
        }
        }
    return sortie;
    }

    //recherche personne par zone et nom
    public String parPrenomparNomparZone(String prenompersonne, String nompersonne, String nomzone) {
        if(!nompersonne.equals("") && !prenompersonne.equals("")){
        try {
            java.util.Vector<Request> v = new java.util.Vector<Request>();
            v.add(new Request("true", "givenName", "EGAL", prenompersonne, "ET"));
            v.add(new Request("true", "sn", "EGAL", nompersonne, "ET"));
            v.add(new Request("true", "uppaDrhComposante", "ENVEGAL", nomzone, "NULL"));

            java.util.List<String> result = Annuaire_UPPA.People_attribute_values(v);

            sortie = "";
            for (String s : result) {
                sortie += affichage(s);
            }
        } catch (javax.naming.NamingException ne) {
            System.err.println(ne.getMessage() +" " +ne.getExplanation());
            }
        }

        if(nompersonne.equals("") && !prenompersonne.equals("")){
        try {
            java.util.Vector<Request> v = new java.util.Vector<Request>();
            v.add(new Request("true", "givenName", "EGAL", prenompersonne, "ET"));
            v.add(new Request("true", "uppaDrhComposante", "ENVEGAL", nomzone, "NULL"));

            java.util.List<String> result = Annuaire_UPPA.People_attribute_values(v);

            sortie = "";
            for (String s : result) {
                sortie += affichage(s);
            }
        } catch (javax.naming.NamingException ne) {
            System.err.println(ne.getMessage() +" " +ne.getExplanation());
            }
        }

        if(!nompersonne.equals("") && prenompersonne.equals("")){
        try {
            java.util.Vector<Request> v = new java.util.Vector<Request>();
            v.add(new Request("true", "sn", "EGAL", nompersonne, "ET"));
            v.add(new Request("true", "uppaDrhComposante", "ENVEGAL", nomzone, "NULL"));

            java.util.List<String> result = Annuaire_UPPA.People_attribute_values(v);

            sortie = "";
            for (String s : result) {
                sortie += affichage(s);
            }
        } catch (javax.naming.NamingException ne) {
            System.err.println(ne.getMessage() +" " +ne.getExplanation());
            }
        }


        if(nompersonne.equals("") && prenompersonne.equals("") && !nomzone.equals("")){
        try {
            java.util.Vector<Request> v = new java.util.Vector<Request>();
            v.add(new Request("true", "givenName", "EGAL", prenompersonne, "ET"));
            v.add(new Request("true", "sn", "EGAL", nompersonne, "ET"));
            v.add(new Request("true", "uppaDrhComposante", "ENVEGAL", nomzone, "NULL"));

            java.util.List<String> result = Annuaire_UPPA.People_attribute_values(v);

            sortie = "";
            for (String s : result) {
                sortie += affichage(s);
            }
        } catch (javax.naming.NamingException ne) {
            System.err.println(ne.getMessage() +" " +ne.getExplanation());
            }
        }

    return sortie;
    }


        public String parTelephone(String tel) {
            String tel1=" "+tel;
        try {
            java.util.Vector<Request> v = new java.util.Vector<Request>();
            v.add(new Request("true", "telephoneNumber", "EGAL", tel, "OU"));
            v.add(new Request("true", "telephoneNumber", "EGAL", testTel(tel1), "NULL"));

            java.util.List<String> result = Annuaire_UPPA.People_attribute_values(v);
            sortie = "";
            for (String s : result) {
                sortie += affichage(s);
            }
        } catch (javax.naming.NamingException ne) {
            System.err.println(ne.getMessage() +" " +ne.getExplanation());
        }
        return sortie;
    }

        public String parNomparPrenom(String prenompersonne,String nompersonne){
        if(!nompersonne.equals("") && !prenompersonne.equals("")){
        try {
            java.util.Vector<Request> v = new java.util.Vector<Request>();
            v.add(new Request("true", "givenName", "EGAL", prenompersonne, "ET"));
            v.add(new Request("true", "sn", "EGAL", nompersonne, "NULL"));

            java.util.List<String> result = Annuaire_UPPA.People_attribute_values(v);

            sortie = "";
            for (String s : result) {
                sortie += affichage(s);
            }
        } catch (javax.naming.NamingException ne) {
            System.err.println(ne.getMessage() +" " +ne.getExplanation());
            }
        }

        if(nompersonne.equals("") && !prenompersonne.equals("")){
        try {
            java.util.Vector<Request> v = new java.util.Vector<Request>();
            v.add(new Request("true", "givenName", "EGAL", prenompersonne, "NULL"));

            java.util.List<String> result = Annuaire_UPPA.People_attribute_values(v);

            sortie = "";
            for (String s : result) {
                sortie += affichage(s);
            }
        } catch (javax.naming.NamingException ne) {
            System.err.println(ne.getMessage() +" " +ne.getExplanation());
            }
        }
        if(!nompersonne.equals("") && prenompersonne.equals("")){
        try {
            java.util.Vector<Request> v = new java.util.Vector<Request>();
            v.add(new Request("true", "sn", "EGAL", nompersonne, "NULL"));

            java.util.List<String> result = Annuaire_UPPA.People_attribute_values(v);

            sortie = "";
            for (String s : result) {
                sortie += affichage(s);
            }
        } catch (javax.naming.NamingException ne) {
            System.err.println(ne.getMessage() +" " +ne.getExplanation());
            }
        }
    return sortie;
    }

}