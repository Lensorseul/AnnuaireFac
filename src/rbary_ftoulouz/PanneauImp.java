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

public class PanneauImp extends JPanel {

 private JLabel labelimg = new JLabel (new ImageIcon("construct.png"));
    private JLabel labeltxta = new JLabel ("Fonction impression en construction");

    public PanneauImp (){
        this.setBackground(Color.gray);
        this.add(labelimg);
        this.add(labeltxta);
    }

}
