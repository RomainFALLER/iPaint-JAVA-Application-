/**
 * Created by wolfy on 02/06/15.
 */
import java.awt.Color;
import java.awt.Graphics;

public class Rectangle extends Figure{

    protected int longueur;
    protected int largeur;


    public int getLongueur() {
        return longueur;
    }


    public void setLongueur(int longueur) {
        this.longueur = longueur;
    }


    public int getLargueur() {
        return largeur;
    }


    public void setLargueur(int largueur) {
        this.largeur = largueur;
    }

    public double getPerimetre() {
        return (longueur * 2 + largeur * 2);
    }

    public double getSurface() {
        return (longueur * largeur);
    }


    public Rectangle(int x,int y,int longueur, int largueur,Color c) {

        super(new Point(x,y),c);
        this.largeur = largueur;
        this.longueur = longueur;
    }

    public Rectangle(int longueur, int largueur) {

        super(new Point());
        this.largeur = largueur;
        this.longueur = longueur;
    }

    public Rectangle(int px,int py,Color c) {

        super(new Point(px,py),c);
        this.largeur = 0;
        this.longueur = 0;
    }


    public String toString() {

        String rect = "";
		/*
		int i, j;


		for (i = 0; i <= this.getLargueur(); i++) {

			if (i == 0 || i == (this.getLargueur() )) {
				rect += "+";
				for (j = 0; j < this.getLongueur(); j++) {
					rect += "--";
				}
				rect += "+\n";
			} else {
				rect += "|";
				for (j = 0; j < this.getLongueur(); j++) {
					rect += "  ";
				}
				rect += "|\n";
			}

		}*/
        rect += getLongueur();
        rect += "  ";
        rect += getLargueur();
        rect += "  ";
        rect += c;
        return rect;
    }


    @Override
    public void setBoundingBox(int hauteurBB, int largeurBB) {
        this.longueur = hauteurBB;
        this.largeur = largeurBB;
    }



    @Override
    public void draw(Graphics g) {
        g.setColor(this.c);
        g.fillRect(this.origine.getX(), this.origine.getY(), this.getLongueur(), this.getLargueur());
    }

}
