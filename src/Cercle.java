/**
 * Created by wolfy on 02/06/15.
 */
import java.awt.Color;

public class Cercle extends Ellipse{

    public Cercle(int x, int y, int diametre,Color c)
    {
        super(x,y,diametre,diametre,c);
    }

    public void setGrandAxe(int grandAxe)
    {
        this.grandAxe = grandAxe;
        this.petitAxe = grandAxe;
    }

    public void setPetitAxe(int petitAxe)
    {
        this.petitAxe = petitAxe;
        this.grandAxe = petitAxe;
    }

    @Override
    public void setBoundingBox(int hauteurBB, int largeurBB) {
        super.setBoundingBox(hauteurBB,hauteurBB);
    }

    public Cercle(int rayon)
    {
        super(rayon,rayon);
    }

    public Cercle(int px,int py,Color c)
    {
        super(px,py,c);
    }

}
