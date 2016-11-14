import java.awt.*;

/**
 * Created by wolfy on 02/06/15.
 */
public class Trait extends Figure {
    protected int longueur;
    protected int largeur;
    private int x1;
    private int y1;
    private int x2;
    private int y2;



    public int getLongueur() {
        return longueur;
    }

    public int getLargeur() {
        return largeur;
    }

    public void setLongueur(int longueur) {
        this.longueur = longueur;
    }

    public void setLargeur(int largeur) {
        this.largeur = largeur;
    }

    public Trait(int x1,int y1,int x2,int y2, Color c) {

        super(new Point(x1,y1),c);
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
    }

    public Trait(int px,int py,Color c) {

        super(new Point(px,py),c);
        this.longueur = 0;
        this.largeur = 0;
    }


    public double getSurface() {
        return (longueur);
    }

    public double getPerimetre() {
        return (longueur);
    }

    public int getX1() {
        return x1;
    }
    public void setX1(int x1) {
        this.x1 = x1;
    }
    public int getY1() {
        return y1;
    }
    public void setY1(int y1) {
        this.y1 = y1;
    }
    public int getX2() {
        return x2;
    }
    public void setX2(int x2) {
        this.x2 = x2;
    }
    public int getY2() {
        return y2;
    }
    public void setY2(int y2) {
        this.y2 = y2;
    }

    @Override
    public void setBoundingBox(int hauteurBB, int largeurBB) {
        this.longueur = hauteurBB;
        this.largeur = largeurBB;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(this.c);
        g.drawLine(x1,y1,x2,y2);
    }

}
