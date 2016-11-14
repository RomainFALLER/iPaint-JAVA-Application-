import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;



/**
 * Created by wolfy on 02/06/15.
 */
@SuppressWarnings("serial")
public class Dessin extends JPanel {
    protected int x;
    protected int y;
    protected ArrayList<Figure> liste;
    protected Color c;
    protected String Figurename;
    protected Figure currentFigure;
    protected Point p;
    protected Image img;


    public Dessin()
    {
        super();
        this.c = Color.black;
        this.Figurename = "";
        this.liste = new ArrayList<Figure>();


        }


    public ArrayList<Figure> getListe()
    {
        return liste;
    }
    public Figure getCurrentFigure() {
        return currentFigure;
    }
    public void setCurrentFigure(Figure currentFigure)
    {
        this.currentFigure = currentFigure;
    }
    public void setC(Color c)
    {
        this.c = c;
    }

    public Color getC()
    {
        return c;
    }
/**
    public void setDess(boolean dess)
    {
        this.dess = dess;
    }

    public boolean getDess()
    {
        return dess;
    }**/


    public void setFigurename (String Figurename)
    {
        this.Figurename = Figurename;
    }
    public void setImg(Image img)
    {
        this.img = img;
    }

    public String getFigurename()
    {
        return Figurename;
    }

    protected void paintComponent (Graphics g) {
        super.paintComponent(g);
        setBackground(Color.white);

        if (this.img != null)
            g.drawImage(this.img, 0, 0, this);

        for (Figure f : liste) {
            f.draw(g);
        }

        if (currentFigure != null) {
            currentFigure.draw(g);
        }
    }

    public void OpenFile() throws IOException {
        JFileChooser path = new JFileChooser();


        int retour = path.showOpenDialog(this);
        if (retour == JFileChooser.APPROVE_OPTION) {
            String chemin = path.getSelectedFile().getAbsolutePath();

            this.liste.clear();
            this.setImg(ImageIO.read(new File(chemin)));

            repaint();

        }

    }

}


