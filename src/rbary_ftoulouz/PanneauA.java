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


public class PanneauA extends JPanel {
    private JLabel labelimg = new JLabel (new ImageIcon("logoUppa.png"));
    private JLabel labeltxta = new JLabel ("BIENVENUE DANS LA RECHERCHE ANNUAIRE DE L'UPPA");
    public PanneauA(){
        this.setBackground(Color.gray);
        this.add(labelimg);
        this.add(labeltxta);
    }
}