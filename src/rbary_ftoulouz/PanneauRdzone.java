/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rbary_ftoulouz;

/**
 *
 * @author ftoulouz
 */
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.*;
import javax.swing.*;


public class PanneauRdzone extends JPanel implements ActionListener{
     private JLabel labelnom = new JLabel("Nom: ");
        private JTextField jtfnom = new JTextField("");
        private JLabel labelprenom = new JLabel("Prenom: ");
        private JTextField jtfprenom = new JTextField("");
        private JButton buttonSearch = new JButton ("Rechercher");
        private JButton buttonReset = new JButton (new ImageIcon("balai1.png"));
        private JTextArea areaResult = new JTextArea ();
        private JLabel labelUfr = new JLabel ("UFR");
        private JComboBox comboZone = new JComboBox();
        private cherchePersonne cherchepersonne=new cherchePersonne();

        public PanneauRdzone () {
            //Mise en place du JComboBox(dimensionnement)
            comboZone.addItem("Sciences");
            comboZone.addItem("Droit");
            comboZone.addItem("Lettres");
            this.setBackground(Color.gray);
            this.setBorder(BorderFactory.createTitledBorder("Recherche par zone"));

            areaResult.setEditable(false);
            JScrollPane vscroll = new JScrollPane(areaResult,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
            areaResult.setLineWrap(true);
            areaResult.setWrapStyleWord(true);
            //Ajout de tous les elements panneau
            this.add(labelnom);
            this.add(jtfnom);
            this.add(labelprenom);
            this.add(jtfprenom);
            this.add(buttonSearch);
            this.add(buttonReset);
            this.add(labelUfr);
            this.add(comboZone);
            this.add(vscroll);

            //Ajout d'un ActionListener
            buttonSearch.addActionListener(this);
            buttonReset.addActionListener(this);
            
            GroupLayout layout = new GroupLayout(this);
            this.setLayout(layout);
            layout.setAutoCreateGaps(true);
            layout.setAutoCreateContainerGaps(true);
            layout.setHorizontalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(labelnom)
                    .addComponent(labelprenom)
                    .addComponent(labelUfr)
                    .addComponent(buttonReset))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jtfnom)
                    .addComponent(jtfprenom)
                    .addComponent(comboZone)
                    .addComponent(buttonSearch)
                    .addComponent(vscroll))
            );
            layout.setVerticalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(labelnom)
                    .addComponent(jtfnom))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(labelprenom)
                    .addComponent(jtfprenom))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(labelUfr)
                    .addComponent(comboZone))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonSearch))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(vscroll))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonReset))
            );
        }

        public void actionPerformed (ActionEvent evt) {
        if(evt.getSource() == buttonSearch){
              areaResult.setText(cherchepersonne.parPrenomparNomparZone(jtfprenom.getText(), jtfnom.getText(),comboZone.getSelectedItem().toString()));
        }

        if(evt.getSource() == buttonReset){
            jtfnom.setText(null);
            jtfprenom.setText(null);
            areaResult.setText(null);
        }
    }
}