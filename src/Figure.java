/**
 * Created by wolfy on 02/06/15.
 */
import java.awt.Color;
import java.awt.Graphics;

public abstract class Figure {

    protected Point origine;
    protected Color c;
    protected boolean nouveau;


    public Figure(Point p,Color co) {
        this.origine = p;
        this.c = co;
    }

    public Figure(Point p)
    {
        origine=p;
    }


    public String toString()
    {
        String name = new String();
        name = "x=";
        name += this.origine.getX();
        name += "\ny=";
        name += this.origine.getY();

        return name;
    }

    public boolean isNouveau() {
        return nouveau;
    }
    public void setNouveau(boolean nouveau) {
        this.nouveau = nouveau;
    }

    public String getOrigine(){
        String org = origine.cord();
        return org;
    }

    public abstract double getPerimetre();

    public abstract double getSurface();

    abstract void setBoundingBox(int hauteurBB, int largeurBB);

    public abstract void draw(Graphics g);
}