/**
 * Created by wolfy on 02/06/15.
 */
import java.awt.*;

public class Point {
    private int x;
    private int y;
    private Color color;
    private int size = 10;
    private String type = "ROND";



    public Point(){
        x=0;
        y=0;
    }

    public Point(int x,int y, int size, Color c, String type){
        setX(x);
        setY(y);
        setSize(size);
        setColor(c);
        setType(type);
    }


    public Point(int x,int y){
        setX(x);
        setY(y);
    }

    public int getSize() {
        return size;
    }
    public void setSize(int size) {
        this.size = size;
    }

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

    public Color getColor() {
        return color;
    }
    public void setColor(Color color) {
        this.color = color;
    }
    public int getY() {
        return y;
    }
    public int getX() {
        return x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public String cord()
    {
        String text;
        text= "Abscisse: "+getX()+" Ordonnée : "+getY();
        return text;
    }

}
