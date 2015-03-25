package rbary_ftoulouz;

/**
 *
 * @author ftoulouz
 */
/**
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.Graphics;
import javax.swing.*;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;
import javax.swing.Box;

//import javax.swing.ImageIcon;
/**
 *
 * @author rbary
 */
public class Graphiqwind extends JFrame implements ActionListener {

    /*Creation d'une instance de cherche personne*/
    private cherchePersonne chp= new cherchePersonne();


    /*Declaration des elements du menu*/
    private JMenuBar menuBar = new JMenuBar();
    private JMenu menu1 = new JMenu("Type de recherche");
          private JMenu menu1_2 = new JMenu ("Recherche détaillée");
    private JMenu menu2 = new JMenu("Exporter/Imprimer");
    private JMenu menu3 = new JMenu("A propos") ;

    private JMenuItem item1_0 = new JMenuItem("Accueil");
    private JMenuItem item1_1 = new JMenuItem("Recherche express");
    private JMenuItem item1_3 = new JMenuItem("Recherche Téléphonique");
    private JMenuItem item1_4 = new JMenuItem("Fermer");
    private JMenuItem item2_1 = new JMenuItem("Exporter");
    private JMenuItem item2_2 = new JMenuItem("Imprimer");
    private JMenuItem item3_1 = new JMenuItem("?");
    private PanneauA pna = new PanneauA();
    private PanneauRe pnre = new PanneauRe();
    private PanneauRdstatut pnrds = new PanneauRdstatut();
    private PanneauRdzone pnrdz = new PanneauRdzone();
    private PanneauRtel pnrtel = new PanneauRtel();
    private PanneauEx pnex = new PanneauEx();
    private PanneauImp pnimp = new PanneauImp();
    private PanneauApro pnapro = new PanneauApro();


    private JMenuItem jrmiStatut = new JMenuItem("Statut");
    private JMenuItem jrmiZone = new JMenuItem("UFR");

    public Graphiqwind(){
        //Titre de la fenetre graphique
        this.setTitle("Annuaire Université de Pau");
        //Taille:500px de large et 400 px de large
        this.setSize(500,400);
        //Faire positionner l'objet à la position x,y=100
        this.setLocation(100,100);
        this.setResizable(false);
        //Termine le processus lorsqu'on clique sur la croix rouge
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //On indique au JFrame que pna est son Panneau par défaut
        this.setContentPane(pna);

        /*Initialisation des menus**********************************************************************/
        //Menu type de recherche/Ajout des sous-menu
        this.menu1.add(item1_0);
        this.menu1.add(item1_1);
        this.menu1.add(this.menu1_2);
        this.menu1.add(item1_3);
        this.menu1.add(item1_4);

        //Menu Exporter-Imprimer/Ajout des sous-menu
        this.menu2.add(item2_1);
        this.menu2.add(item2_2);

        //Menu A propos
        this.menu3.add(item3_1);

        //Mise en place de la barre de menu/Ajout des sous-menu
        this.menuBar.add(menu1);
        this.menuBar.add(menu2);
        this.menuBar.add(menu3);
        // shift to the right
        menuBar.add(Box.createGlue());
        this.setJMenuBar(menuBar);

        //Mise en place des subsubMenu+ajout d'un séparateur
        this.menu1_2.add(jrmiStatut);
        this.menu1_2.add(jrmiZone);



        //la rendre visible
        this.setVisible(true);
        //la mettre au premier plan
        this.setAlwaysOnTop(true);

        //Ajout de ActionListener
        item1_0.addActionListener(this);
        item1_1.addActionListener(this);
        jrmiStatut.addActionListener(this);
        jrmiZone.addActionListener(this);
        item1_3.addActionListener(this);
        item1_4.addActionListener(this);
        item2_1.addActionListener(this);
        item2_2.addActionListener(this);
        item3_1.addActionListener(this);
    }

   public void actionPerformed (ActionEvent evt) {
        if(evt.getSource() == item1_4){
                   System.exit(0);
        }
        
        if(evt.getSource() == item1_0){
            this.setContentPane(pna);
            this.setVisible(true);
        }

        if(evt.getSource() == item1_1){
             this.setContentPane(pnre);
             this.setVisible(true);
       }
       if(evt.getSource() == jrmiStatut){
           this.setContentPane(pnrds);
           this.setVisible(true);
       }

       if(evt.getSource() == jrmiZone){
           this.setContentPane(pnrdz);
           this.setVisible(true);

       }

       if(evt.getSource() == item1_3){
           this.setContentPane(pnrtel);
           this.setVisible(true);
       }

       if(evt.getSource() == item2_1){
           this.setContentPane(pnex);
           this.setVisible(true);
       }

       if(evt.getSource() == item2_2){
           this.setContentPane(pnimp);
           this.setVisible(true);
       }

       if(evt.getSource() == item3_1){
           this.setContentPane(pnapro);
           this.setVisible(true);
       }
}
}









