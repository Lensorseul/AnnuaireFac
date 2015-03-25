/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rbary_ftoulouz;

import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.Graphics;
import java.awt.event.ActionListener;
/**
 *
 * @author ftoulouz
 */
public class PanneauRtel extends JPanel implements ActionListener {

    private JLabel labelnumtel = new JLabel("N°Télephone: +33");
    private JTextField jtfnumtel = new JTextField(16);
    private JButton buttonSearch = new JButton ("Rechercher");
    private JButton buttonReset = new JButton (new ImageIcon("balai1.png"));
    private JTextArea areaResult = new JTextArea ();
    private cherchePersonne cherchepersonne=new cherchePersonne();


    public PanneauRtel(){
    this.setBackground(Color.gray);
    this.setBorder(BorderFactory.createTitledBorder("Recherche par téléphone"));
    areaResult.setEditable(false);

    JScrollPane vscroll = new JScrollPane(areaResult,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
            JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    areaResult.setLineWrap(true);
    areaResult.setWrapStyleWord(true);
    //Ajout de tous les elements panneau
    this.add(labelnumtel);
    this.add(buttonSearch);
    this.add(buttonReset);
    this.add(vscroll);

    GroupLayout layout = new GroupLayout(this);
            this.setLayout(layout);
            layout.setAutoCreateGaps(true);
            layout.setAutoCreateContainerGaps(true);
            layout.setHorizontalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(labelnumtel)
                    .addComponent(buttonReset))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jtfnumtel)
                    .addComponent(buttonSearch)
                    .addComponent(vscroll))
            );
            layout.setVerticalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(labelnumtel)
                    .addComponent(jtfnumtel))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonSearch))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(vscroll))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonReset))
            );

         //Ajout de ActionListener
         buttonSearch.addActionListener(this);
         buttonReset.addActionListener(this);

        }

    public void actionPerformed (ActionEvent evt) {
        if(evt.getSource() == buttonSearch){
              areaResult.setText(cherchepersonne.parTelephone(jtfnumtel.getText() ));
        }

        if(evt.getSource() == buttonReset){
              areaResult.setText(null);
              jtfnumtel.setText(null);
        }
    }
}
