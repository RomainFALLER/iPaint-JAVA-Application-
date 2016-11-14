/**
 * Created by wolfy on 02/06/15.
 */
import java.awt.Color;
import java.awt.Graphics;

public class Ellipse extends Figure {

    public final float PI = 3.14f;

    protected int grandAxe;
    protected int petitAxe;

    public Ellipse(int x, int y, int grandAxe,int petitAxe,Color c){
        super(new Point(x,y),c);
        this.grandAxe = grandAxe;
        this.petitAxe = petitAxe;
    }

    public Ellipse(int grandAxe,int petitAxe){
        super(new Point());
        this.grandAxe = grandAxe;
        this.petitAxe = petitAxe;
    }

    public Ellipse(int px, int py,Color c){
        super(new Point(px,py),c);
        this.grandAxe = 0;
        this.petitAxe = 0;
    }


    public int getGrandAxe() {
        return grandAxe;
    }

    public void setGrandAxe(int grandAxe) {
        this.grandAxe = grandAxe;
    }

    public int getPetitAxe() {
        return petitAxe;
    }

    public void setPetitAxe(int petitAxe) {
        this.petitAxe = petitAxe;
    }

    public double getPerimetre()
    {
        return (double)(Math.PI*(grandAxe + petitAxe));
    }

    public double getSurface()
    {
        return (double)(Math.PI*grandAxe*petitAxe/4);
    }

    @Override
    void setBoundingBox(int hauteurBB, int largeurBB) {
        this.grandAxe = hauteurBB;
        this.petitAxe = largeurBB;

    }

    @Override
    public void draw(Graphics g) {
        g.setColor(this.c);
        g.fillOval(this.origine.getX(), this.origine.getY(), this.grandAxe, this.petitAxe);
    }


}