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

public class PanneauEx extends JPanel {
    private JLabel labelimg = new JLabel (new ImageIcon("construct.png"));
    private JLabel labeltxta = new JLabel ("Fonction exporter en construction");

    public PanneauEx(){
        this.setBackground(Color.gray);
        this.add(labelimg);
        this.add(labeltxta);
    }
}
