/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rbary_ftoulouz;

/**
 *
 * @author ftoulouz
 */
public class Request {
     private String attr;
    private String value;
    private boolean estPresent;
    private Oeg opEgal;
    private OEtOu opEtOu;

    public String getStrEtOu() {
        if (OEtOu.ET == opEtOu) {
            return "(&";
        } else if (OEtOu.OU == opEtOu) {
            return "(|";
        } else {
            return "";
        }
    }

    public enum Oeg {

        EGAL, INFEGAL, SUPEGAL, ENVEGAL
    }

    public enum OEtOu {

        ET, OU, NULL
    }

    public Request(String Present, String attr, String op, String value, String eoop) {
        System.out.println("-->" + Present + "," + attr + "," + op + "," + value + "," + eoop);
        this.attr = attr;
        this.value = value;

        if (Present == null) {
            estPresent = true;
        } else if (Present.compareTo("true") == 0) {
            estPresent = true;
        } else {
            estPresent = false;
        }

        if (op.compareTo("EGAL") == 0) {
            opEgal = Oeg.EGAL;
        } else if (op.compareTo("INFEGAL") == 0) {
            opEgal = Oeg.INFEGAL;
        } else if (op.compareTo("ENVEGAL") == 0) {
            opEgal = Oeg.ENVEGAL;
        } else if (op.compareTo("SUPEGAL") == 0) {
            opEgal = Oeg.SUPEGAL;
        }

        if (eoop == null) {
            opEtOu = OEtOu.NULL;
        } else if (eoop.compareTo("NULL") == 0) {
            opEtOu = OEtOu.NULL;
        } else if (eoop.compareTo("ET") == 0) {
            opEtOu = OEtOu.ET;
        } else if (eoop.compareTo("OU") == 0) {
            opEtOu = OEtOu.OU;
        }

        System.out.println("FILTRE: " + this.getTotalFilter());
    }

    public String getTotalFilter() {
        String str = "";

        if (estPresent) {
            str += "(" + this.getAttr() + getSigne() + this.getValue() + ")";
        } else {
            str += "(" + getEstPresent() + "(" + this.getAttr() + getSigne() + this.getValue() + "))";
        }

        return str;
    }

    public String getEstPresent() {
        if (estPresent) {
            return "";
        } else {
            return "!";
        }
    }

    private String getSigne() {
        if (opEgal == Oeg.EGAL) {
            return "=";
        } else if (opEgal == Oeg.ENVEGAL) {
            return "~=";
        } else if (opEgal == Oeg.INFEGAL) {
            return "<=";
        } else if (opEgal == Oeg.SUPEGAL) {
            return ">=";
        }
        return "=";
    }

    public boolean isEstPresent() {
        return estPresent;
    }

    public void setEstPresent(boolean estPresent) {
        this.estPresent = estPresent;
    }

    public Oeg getOpEgal() {
        return opEgal;
    }

    public void setOpEgal(Oeg opEgal) {
        this.opEgal = opEgal;
    }

    public OEtOu getOpEtOu() {
        return opEtOu;
    }

    public void setOpEtOu(OEtOu opEtOu) {
        this.opEtOu = opEtOu;
    }

    public void setAttr(String attr) {
        this.attr = attr;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getAttr() {
        return attr;
    }

    public String getValue() {
        return value;
    }
}