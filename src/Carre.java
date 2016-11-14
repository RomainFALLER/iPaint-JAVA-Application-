/**
 * Created by wolfy on 02/06/15.
 */
import java.awt.Color;

public class Carre extends Rectangle {

    public Carre(int x, int y,int cote,Color c)
    {
        super(x,y,cote,cote,c);
    }

    public void setLongueur(int longueur)
    {
        this.longueur = longueur;
        this.largeur = longueur;
    }

    public void setLargeur(int largeur){
        this.longueur = largeur;
        this.largeur = largeur;
    }

    @Override
    public void setBoundingBox(int hauteurBB, int largeurBB) {
        super.setBoundingBox(hauteurBB,hauteurBB);
    }

    public Carre(int cote)
    {
        super(cote,cote);
    }

    public Carre(int px,int py, Color c)
    {
        super(px,py,c);
    }

}