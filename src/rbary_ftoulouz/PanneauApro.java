/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rbary_ftoulouz;

/**
 *
 * @author ftoulouz
 */
import java.awt.*;
import javax.swing.*;

public class PanneauApro extends JPanel {
    //private JLabel labelimg = new JLabel (new ImageIcon("logoUppa.png"));
    private JTextArea texta = new JTextArea (" Recherche Annuaire Uppa est une application basée sur \n"
            + " le protocole LDAP permettant d'interroger des services d'annuaire.\n"
            + " Cette application a été développée par Roland Bary et Franck Toulouze.\n"
            + " Vous avez des questions ? \n "
            + " Recherchez nous grâce à l'application et contactez nous pas mail.");
    public PanneauApro(){
        texta.setEditable(false);
        this.setBackground(Color.white);
        this.add(texta);
    }


}
