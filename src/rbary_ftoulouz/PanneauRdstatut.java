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
import java.awt.event.*;
import java.awt.Dimension;
import javax.swing.*;

public class PanneauRdstatut extends JPanel implements ActionListener {
        private JLabel labelnom = new JLabel("Nom: ");
        private JTextField jtfnom = new JTextField("");
        private JLabel labelprenom = new JLabel("Prenom: ");
        private JTextField jtfprenom = new JTextField("");
        private JButton buttonSearch = new JButton ("Rechercher");
        private JButton buttonReset = new JButton (new ImageIcon("balai1.png"));
        private JTextArea areaResult = new JTextArea ();
        private JLabel labelStatut = new JLabel ("Statut");
        private JComboBox comboStatut = new JComboBox();
        private cherchePersonne cherchepersonne=new cherchePersonne();
        private Thread thread = new Thread();
        private JProgressBar bar = new JProgressBar();

        public PanneauRdstatut () {     
            //Mise en place du JComboBox(dimensionnement)
            comboStatut.setPreferredSize(new Dimension(100,20));
            comboStatut.addItem("Enseignant");
            comboStatut.addItem("Etudiant");
            comboStatut.addItem("Personnel");
            this.setBackground(Color.gray);
            this.setBorder(BorderFactory.createTitledBorder("Recherche par statut"));

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
            this.add(labelStatut);
            this.add(comboStatut);
            this.add(bar);
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
                    .addComponent(labelStatut)
                    .addComponent(buttonReset))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jtfnom)
                    .addComponent(jtfprenom)
                    .addComponent(comboStatut)
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
                    .addComponent(labelStatut)
                    .addComponent(comboStatut))
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

            /*
             *
             *
             *  t = new Thread(new Traitement());
                t.start();
             */
              if(comboStatut.getSelectedItem().toString()=="Enseignant"){
                areaResult.setText(cherchepersonne.parPrenomparNomparStatut(jtfprenom.getText(), jtfnom.getText(),"teacher"));
              }

              if(comboStatut.getSelectedItem().toString()=="Etudiant"){
                areaResult.setText(cherchepersonne.parPrenomparNomparStatut(jtfprenom.getText(), jtfnom.getText(),"student"));
              }

              if(comboStatut.getSelectedItem().toString()=="Personnel"){
                areaResult.setText(cherchepersonne.parPrenomparNomparStatut(jtfprenom.getText(), jtfnom.getText(),"employee"));
              }
        }

        if(evt.getSource() == buttonReset){
            jtfnom.setText(null);
            jtfprenom.setText(null);
            areaResult.setText(null);
        }
    }
}

