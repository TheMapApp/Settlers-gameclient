import java.awt.*;

public class Middlepoint {
	
	
	int _posx;
	int _posy;
	boolean _lamp = false;
	boolean _lamp2 = false;
	boolean occupied = false;
	Color _color= new Color(0,0,0);
	
	
	Middlepoint(int posx, int posy){
		
	
		
		_posy = posy;
		_posx = posx;
		
		
	
	}
	
	 public boolean mousecheck(){
		 
		 
	 return true;
	 }
	
	
	 public boolean setlamp(boolean lamper){
		 _lamp=lamper;
		 System.out.println("lamp is on");
		 return _lamp;
		
		 
	 }
	 
	 
	 public boolean setlamp2(boolean lamper){
		 _lamp2=lamper;
		 System.out.println("lamp2 is on");
		 return _lamp2;
		
		 
	 }
	
	public void paint(Graphics g) {

		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(2));
		// draws the ellipse
		g.setColor(_color);
		g2.setStroke(new BasicStroke(2));
		g.drawRect(_posx,_posy,15,15	);
		
		if(_lamp==true){
			g.setColor(new Color(30,30,255));
			g2.setStroke(new BasicStroke(2));
		g.fillRect(_posx,_posy,15,15);
		
		}
		
		
	}

}
