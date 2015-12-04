import java.awt.*;

/**
 * Created by jonasakselbilleskov on 03/12/2015.
 */
public class Town {


    int _xpos;
    int _ypos;
    int enemyColor;
    boolean myTown = false;
    Color _color= Player._Playercolor;

    Town(int xpos,int ypos){

        _xpos = xpos;
        _ypos = ypos;
    }

    Town(int xpos,int ypos, int i){
        enemyColor = i;
        Player.setcolor(i);
        _xpos = xpos;
        _ypos = ypos;
    }

    public void paint(Graphics g) {



        // draws the hexagon

        g.setColor(_color);
        if(enemyColor == 1){
            g.setColor(new Color (100, 100, 0));
        }
        g.fillOval(_xpos-10,_ypos-15, 20, 20);
        g.setColor(new Color (0, 0, 0));
        g.drawOval(_xpos-10, _ypos-15,20,20);




    }


}



