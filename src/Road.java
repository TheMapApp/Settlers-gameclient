import java.awt.Color;
import java.awt.Graphics;
import java.awt.geom.Line2D;
import java.awt.*;
import javax.swing.*;
public class Road {
	
	int _xpos;
	int _ypos;
	int _xpos2;
	int _ypos2;
	Color _color = Player._Playercolor;
	
	Road(int xpos, int ypos,int xpos2, int ypos2){

		_xpos = xpos;
		_ypos = ypos;
		_xpos2 = xpos2;
		_ypos2 = ypos2;
	}

public void paint(Graphics g) {

	Graphics2D g2 = (Graphics2D) g;
		
		// draws the hexagon
	
	 g.setColor(_color);

		//g.drawLine(_xpos, _ypos,_xpos2,_ypos2);

	g2.setStroke(new BasicStroke(10));

	g2.draw(new Line2D.Float(_xpos, _ypos,_xpos2,_ypos2));

		}
	}
