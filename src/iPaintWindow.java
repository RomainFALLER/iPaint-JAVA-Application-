/**
 * Created by wolfy on 02/05/15.
 */

import java.awt.*;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.event.*;
import java.util.ArrayList;
import java.io.IOException;


@SuppressWarnings("serial")
public class iPaintWindow extends JFrame implements ActionListener, MouseMotionListener, MouseListener {

    Dessin myDessin;
    protected int x;
    protected int y;
   
    private int epaisseur = 25;
    // Initialisation des boutons&
    private JButton colorButton = new JButton("Couleurs");
    private JButton pencilButton = new JButton();
    private JButton nappeButton = new JButton();
    private JButton droiteButton = new JButton();
    private JButton GumButton = new JButton();
    private JButton backg = new JButton();
    private JButton shapeOvalButtonR = new JButton();
    private JButton shapeRectButtonR = new JButton();
    private JButton shapeSquareButtonR = new JButton();
    private JButton save = new JButton();
    private JButton undo = new JButton();
    JSlider slider = new JSlider(JSlider.HORIZONTAL, 0, 100, 25);
    JLabel coordonnees = new JLabel(x + "||" + y, JLabel.LEFT);
    private JButton shapeOvalButtonV = new JButton("Ellipse");
    private JButton shapeRectButtonV = new JButton("Rectangle");
    private JButton shapeSquareButtonV = new JButton("Carré");
    private JButton imageButton = new JButton("Charger image");
    public boolean desss;
    public Color perso;
    private JFrame mainFrame;
    private JPanel controlPanel;




    iPaintWindow(String titre) {
        super(titre);

        // Icon de fenetre
        ImageIcon icon = new ImageIcon("./images/icon.png");
        this.setIconImage(icon.getImage());
        // Tailles et position de la fenetre
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // quitte l'application en meme temps que la fenetre
        setLocation(300, 200);
        setSize(1100, 800);

        myDessin = new Dessin();
        Container contentPane = getContentPane();
        contentPane.add(myDessin, "Center");
        myDessin.addMouseListener(this);
        myDessin.addMouseMotionListener(this);


        JPanel statusBar = new JPanel();
        JLabel copy = new JLabel();

        // Défintion du panel principal qui regroupe les deux panels
        JPanel panneauOutil = new JPanel();
        panneauOutil.setLayout(new BorderLayout());
        panneauOutil.add(autres());
        panneauOutil.add(outils(), "West");
        Menu();


        //Creating the StatusBar.
        //setLayout(new BorderLayout());//frame layout
        coordonnees.setForeground(Color.black);
        copy.setText("Copyrights Wolfy ");
        statusBar.setLayout(new BorderLayout());
        statusBar.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        statusBar.setBackground(Color.LIGHT_GRAY);
        statusBar.add(coordonnees, BorderLayout.WEST);
        statusBar.add(copy, BorderLayout.EAST);


        // Rend visible la fenetres
        contentPane.add(panneauOutil, "North");
        contentPane.add(statusBar, "South");
        setVisible(true);
    }


    public void Menu() {

        // Barre de menu en haut
        JMenuBar Me = new JMenuBar();

        // Premier onglet fichiers
        JMenu Fichier = new JMenu("Fichier");

        //Différents items
        JMenuItem nouveau = new JMenuItem("Nouveau");
        nouveau.addActionListener(this);
        JMenuItem ouvrir = new JMenuItem("Ouvrir");
        ouvrir.addActionListener(this);
        JMenuItem sauvegarder = new JMenuItem("Sauvegarder");
        sauvegarder.addActionListener(this);
        JMenuItem quitter = new JMenuItem("Quitter");
        quitter.addActionListener(this);

        Fichier.add(nouveau);
        Fichier.add(ouvrir);
        Fichier.add(sauvegarder);

        Fichier.addSeparator();
        Fichier.add(quitter);

        // Raccourcis
        sauvegarder.setAccelerator(KeyStroke.getKeyStroke('S', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask(), false));
        quitter.setAccelerator(KeyStroke.getKeyStroke('Q', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask(), false));
        nouveau.setAccelerator(KeyStroke.getKeyStroke('N', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask(), false));
        ouvrir.setAccelerator(KeyStroke.getKeyStroke('O', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask(), false));


        // Premier onglet fichiers
        JMenu Edition = new JMenu("Édition");

        //Différents items
        JMenuItem retour = new JMenuItem("Retour");
        JMenuItem copier = new JMenuItem("Copier");
        JMenuItem coller = new JMenuItem("Coller");
        JMenuItem couper = new JMenuItem("Couper");

        // On ajoute a la barre de menu
        Edition.add(retour);
        Edition.add(copier);
        Edition.add(coller);
        Edition.add(couper);

        // Raccourcis
        retour.setAccelerator(KeyStroke.getKeyStroke('Z', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask(), false));
        copier.setAccelerator(KeyStroke.getKeyStroke('C', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask(), false));
        coller.setAccelerator(KeyStroke.getKeyStroke('V', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask(), false));
        couper.setAccelerator(KeyStroke.getKeyStroke('X', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask(), false));


        // Premier onglet fichiers
        JMenu Propos = new JMenu("A propos");

        Me.add(Fichier);
        Me.add(Edition);
        Me.add(Propos);

        setJMenuBar(Me);
    }

    public JToolBar outils() {


        colorButton.setIcon(new ImageIcon(getClass().getResource("/images/colour.png")));
        colorButton.addActionListener(this);
        pencilButton.setIcon(new ImageIcon(getClass().getResource("/images/pencil.png")));
        pencilButton.addActionListener(this);
        droiteButton.setIcon(new ImageIcon(getClass().getResource("/images/line.png")));
        droiteButton.addActionListener(this);
        GumButton.setIcon(new ImageIcon(getClass().getResource("/images/gomme.png")));
        GumButton.addActionListener(this);
        shapeOvalButtonR.setIcon(new ImageIcon(getClass().getResource("/images/cercle_rempli.png")));
        shapeOvalButtonR.addActionListener(this);
        shapeRectButtonR.setIcon(new ImageIcon(getClass().getResource("/images/rect_rempli.png")));
        shapeRectButtonR.addActionListener(this);
        shapeSquareButtonR.setIcon(new ImageIcon(getClass().getResource("/images/carre_rempli.png")));
        shapeSquareButtonR.addActionListener(this);
        shapeOvalButtonV.setIcon(new ImageIcon(getClass().getResource("/images/oval.png")));
        shapeOvalButtonV.addActionListener(this);
        shapeRectButtonV.setIcon(new ImageIcon(getClass().getResource("/images/rectangle.png")));
        shapeRectButtonV.addActionListener(this);
        shapeSquareButtonV.setIcon(new ImageIcon(getClass().getResource("/images/square.png")));
        shapeSquareButtonV.addActionListener(this);
        backg.setIcon(new ImageIcon(getClass().getResource("/images/Backg.png")));
        backg.addActionListener(this);
        nappeButton.setIcon(new ImageIcon(getClass().getResource("/images/nappes.png")));
        nappeButton.addActionListener(this);
        imageButton.setIcon(new ImageIcon(getClass().getResource("/images/galleryIcon.png")));
        imageButton.addActionListener(this);

        slider.setMinorTickSpacing(2);
        slider.setMajorTickSpacing(10);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        // We'll just use the standard numeric labels for now...
        slider.setLabelTable(slider.createStandardLabels(10));
        slider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent event) {
                epaisseur = slider.getValue();
            }
        });

        //LES BARRES D'OUTILS
        JToolBar Outils = new JToolBar("Outils de dessin");
        Outils.setBackground(Color.lightGray);

        Outils.add(colorButton);
        Outils.addSeparator();
        //Outils.add(backg);
        Outils.add(imageButton);
        Outils.add(pencilButton);
        //Outils.add(brushButton);
        Outils.add(droiteButton);
        Outils.add(GumButton);
        Outils.add(nappeButton);
        Outils.addSeparator();
        //Outils.add(shapeRectButtonR);
        Outils.add(shapeSquareButtonR);
        Outils.add(shapeOvalButtonR);
        Outils.add(slider);
        Outils.addSeparator();
        Outils.add(shapeRectButtonV);
        Outils.add(shapeSquareButtonV);
        Outils.add(shapeOvalButtonV);

        Outils.setBackground(perso);

        return Outils;
    }

    public JToolBar autres() {

        // Initialisation des boutons
        save.setIcon(new ImageIcon(getClass().getResource("/images/save.png")));
        undo.setIcon(new ImageIcon(getClass().getResource("/images/undo.png")));

        //LES BARRES D'OUTILS
        JToolBar autres = new JToolBar("Sauvegarder/Retour");
        autres.setBackground(Color.lightGray);


        autres.add(undo);
        autres.add(save);
        return autres;
    }

    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        if (cmd.equals("Couleurs")) {
            //prepareGUI();
            perso = JColorChooser.showDialog(mainFrame,
                    "Choisissez une couleur", Color.white);
            colorButton.setBackground(perso);
        } else if (e.getSource() == pencilButton) {
            System.out.print("pencil");
            myDessin.setFigurename("Trait");
        } else if (e.getSource() == droiteButton) {
            System.out.print("line");
            myDessin.setFigurename("line");
        } else if (e.getSource() == backg) {
            System.out.print("background");
        } else if (e.getSource() == shapeOvalButtonR) {
            System.out.print("oval");
            myDessin.setFigurename("dessinCer");
        } else if (e.getSource() == shapeRectButtonR) {
            System.out.print("rect");
        } else if (e.getSource() == shapeSquareButtonR) {
            System.out.print("square");
            myDessin.setFigurename("dessinCar");
        } else if (e.getSource() == GumButton) {
            System.out.print("gummm");
            myDessin.setFigurename("efface");
        } else if (e.getSource() == shapeOvalButtonV) {
            System.out.print("oval V");
            myDessin.setFigurename("Ellipse");
        } else if (e.getSource() == shapeRectButtonV) {
            System.out.print("rect V");
            myDessin.setFigurename("Rectangle");
        } else if (e.getSource() == shapeSquareButtonV) {
            System.out.print("carre V");
            myDessin.setFigurename("Carré");
        } else if (e.getSource() == nappeButton) {
            System.out.print("dashed");
            myDessin.setFigurename("nappe");
        } else if (e.getSource() == undo)
        {
            myDessin.liste.clear();
        }
        else if (e.getSource() == imageButton) {
            try {
                myDessin.OpenFile();
            }
            catch (IOException edx) {
                // TODO Auto-generated catch block
                edx.printStackTrace();
            }
        } else if (e.getSource() == save) {
            System.out.print("save");
        } else if (e.getSource() == undo) {
            System.out.print("back");
        } else if (cmd.equals("Nouveau")) {
            this.myDessin.getListe().removeAll(this.myDessin.getListe());
            this.myDessin.repaint();
        }else if (cmd.equals("Ouvrir")) {
            try {
                myDessin.OpenFile();
            } catch (IOException edx) {
                // TODO Auto-generated catch block
                edx.printStackTrace();
            }
        }else if (cmd.equals("Sauvegarder"))
        {

        } else if (cmd.equals("Quitter"))
        {
            System.out.print("sfsd");
            System.exit(0);
        }
    }

    //******************* Fonctions overide pour MouseListener et MouseMotionListener
    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("Appuyé");
        @SuppressWarnings("unused")
		Figure fig;
        this.x = e.getX();
        this.y = e.getY();
        System.out.println(x + " || " + y);
        fig = new Trait(this.x, this.y, e.getX(), e.getY(), perso);
        this.x = e.getX();
        this.y = e.getY();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        //System.out.println("Bougé");
        this.x = e.getX();
        this.y = e.getY();
        //System.out.println(x + " || " + y);
        coordonnees.setText("X: " + x + " || " + "Y: " + y);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("Relaché");
        Figure fig = null;
        int xC = e.getX();
        int yC = e.getY();
        @SuppressWarnings("unused")
		Graphics g = null;
        if (this.myDessin.getFigurename().equals("Rectangle")) {
            fig = new Rectangle(x, y, perso);

        } else if (this.myDessin.getFigurename().equals("Carré")) {
            fig = new Carre(x, y, perso);

        } else if (this.myDessin.getFigurename().equals("Ellipse")) {
            fig = new Ellipse(x, y, perso);

        } else if (this.myDessin.getFigurename().equals("Cercle")) {
            fig = new Cercle(x, y, perso);

        } else if (this.myDessin.getFigurename().equals("nappe")) {
            fig = new Trait(x, y, perso);
        } else if (this.myDessin.getFigurename().equals("line")) {
            //fig = new Trait(x, y, perso);
            fig = new Trait(x,y,xC,yC,perso);
        } else if (this.myDessin.getFigurename().equals("Trait")) {
            //fig = new Trait(x, y, perso);
            fig = new Trait(this.x, this.y, e.getX(), e.getY(), perso);
            this.x = e.getX();
            this.y = e.getY();

        } else if (this.myDessin.getFigurename().equals("dessinCer")) {
            fig = new Cercle(xC, yC,epaisseur, perso);
        } else if (this.myDessin.getFigurename().equals("dessinCar")) {
            fig = new Carre(xC, yC,epaisseur, perso);
        } else if (this.myDessin.getFigurename().equals("efface")) {
            fig = new Cercle(xC, yC,epaisseur, Color.white);
        }
        if (this.myDessin.getFigurename().equals("dessinCer") || this.myDessin.getFigurename().equals("dessinCar") || (this.myDessin.getFigurename().equals("efface")) || (this.myDessin.getFigurename().equals("Trait")) || (e.getSource() == backg)) {
            //fig.setBoundingBox(e.getX() - this.x, e.getY() - this.y);
            @SuppressWarnings("unused")
			ArrayList<Figure> list = myDessin.getListe();
            this.myDessin.setCurrentFigure(fig);
        } else
        {
            fig.setBoundingBox(e.getX() - this.x, e.getY() - this.y);
            @SuppressWarnings("unused")
			ArrayList<Figure> list = myDessin.getListe();
            this.myDessin.setCurrentFigure(fig);
        }

        myDessin.liste.add(fig);
        this.myDessin.repaint();
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @SuppressWarnings({ "null", "unused" })
	@Override
    public void mouseDragged(MouseEvent e) {
        Figure fig = null;
        int xC = e.getX();
        int yC = e.getY();
        Graphics g = null;
        if (this.myDessin.getFigurename().equals("Rectangle")) {
            fig = new Rectangle(x, y, perso);
        } else if (this.myDessin.getFigurename().equals("Carré")) {
            fig = new Carre(x, y, perso);
        } else if (this.myDessin.getFigurename().equals("Ellipse")) {
            fig = new Ellipse(x, y, perso);
        } else if (this.myDessin.getFigurename().equals("Cercle")) {
            fig = new Cercle(x, y, perso);
        } else if (this.myDessin.getFigurename().equals("Trait")) {
            fig = new Trait(this.x, this.y, xC, yC, perso);
            this.x = e.getX();
            this.y = e.getY();
            //fig = new Trait(x, y, perso);
        } else if (this.myDessin.getFigurename().equals("line")) {
            fig = new Trait(x,y,xC,yC,perso);
        } else if (this.myDessin.getFigurename().equals("nappe")) {
            fig = new Trait(x, y, xC,yC,perso);
        } else if (this.myDessin.getFigurename().equals("dessinCer")) {
            fig = new Cercle(xC, yC,epaisseur, perso);
        } else if (this.myDessin.getFigurename().equals("dessinCar")) {
            fig = new Carre(xC, yC,epaisseur, perso);
        } else if (this.myDessin.getFigurename().equals("efface")) {
            fig = new Carre(xC, yC,epaisseur, Color.white);
        }
        else if (e.getSource() == backg)
        {
            g.fillRect(0,0,this.getWidth()-1,this.getHeight()-1);
            g.setColor(perso);
            //myDessin.paintComponent2(g,perso);
        }
        if (this.myDessin.getFigurename().equals("dessinCer") || this.myDessin.getFigurename().equals("dessinCar") || (this.myDessin.getFigurename().equals("efface")) || (this.myDessin.getFigurename().equals("Trait")) || (e.getSource() == backg)) {
            //fig.setBoundingBox(e.getX() - this.x, e.getY() - this.y);
            ArrayList<Figure> list = myDessin.getListe();
            myDessin.liste.add(fig);
            this.myDessin.setCurrentFigure(fig);
        } else if (this.myDessin.getFigurename().equals("nappe"))
        {
            fig.setBoundingBox(e.getX() - this.x, e.getY() - this.y);
            ArrayList<Figure> list = myDessin.getListe();
            this.myDessin.setCurrentFigure(fig);
            myDessin.liste.add(fig);
        }
        else
        {
            fig.setBoundingBox(e.getX() - this.x, e.getY() - this.y);
            ArrayList<Figure> list = myDessin.getListe();
            this.myDessin.setCurrentFigure(fig);
        }
        this.myDessin.repaint();
    }

    @SuppressWarnings("unused")
	private void showColorChooserDemo() {

        JButton chooseButton = new JButton("Choose Background");
        chooseButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Color backgroundColor = JColorChooser.showDialog(mainFrame,
                        "", Color.white);
                if (backgroundColor != null) {
                    controlPanel.setBackground(backgroundColor);
                    mainFrame.getContentPane().setBackground(backgroundColor);
                }
            }
        });
        controlPanel.add(chooseButton);


    }
}
