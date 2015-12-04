import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;


//This class overall contains the available buttons throughout the whole game: the buttons for buying roads, settlements and cities and the buttons for taking turns
public class Buying extends JPanel implements MouseListener{

    //Objects of classes
    Trading trading;
    Image imageRoad, imageSettlement, imageCity, imageTurning, imagePopUp;

    boolean window, window1, window2, window3; //variable of type boolean needed to control which window is opened

    static boolean roadactive = false, houseactive = false, townactive = false; //variable of type boolean useful for making it possible to build things (roads, cities or settlements)

    Connecter connect = new Connecter(); //create an instance of the class Connecter()

    //constructor of Buying() class
    Buying(){

        //the trading class is initiated here
        trading = new Trading();
    }

    //paint method where images are drawn
    public void paint(Graphics g) {
        if (Main.gameStart) {

            //width and height of the game map in order to use it for coordinates of buttons
            int width = 800;
            int height = 600;

            //gives the directory of the image file that is going to be drawn
            ImageIcon turns = new ImageIcon("images/turns.png");
            //accesses the image from the location previously mentioned
            imageTurning = turns.getImage();
            //the image is drawn at the specified location on the window
            g.drawImage(imageTurning, width - 780, height - 150, null);


            //gives the directory of the image file that is going to be drawn for the road, settlement and city buttons respectively
            ImageIcon road = new ImageIcon("images/Road.png");
            ImageIcon settlement = new ImageIcon("images/Settlement.png");
            ImageIcon city = new ImageIcon("images/City.png");


            //accesses the image from the locations previously mentioned
            //each image is recognized by its name: imageRoad prints road buttons, etc.
            imageRoad = road.getImage();
            imageSettlement = settlement.getImage();
            imageCity = city.getImage();


            //the images are drawn at the specified location on the game map
            g.drawImage(imageRoad, width - 100, height - 120, null);
            g.drawImage(imageSettlement, width - 100, height - 200, null);
            g.drawImage(imageCity, width - 100, height - 280, null);


            //if any of the road, settlement or city button is pressed, then draw a new window which is a pop-up serving as confirmation
            if (window == true) {
                //create a confirmation window
                g.setColor(Color.GRAY);
                //draw the confirmation window
                g.drawRect(200, 200, 400, 200);
                //draw the picture that serves as a confirmation window from the location given at x = 200 and y = 200
                ImageIcon popUp = new ImageIcon("images/itempopup.png");
                imagePopUp = popUp.getImage();
                g.drawImage(imagePopUp, 200, 200, null);


            }


        }
    }


/* Mathematical method used to calculate the distance between two points
	public double dist(int x1, int x2, int y1, int y2 ){
		double dist;
		float xdif;
		float ydif;
		
			if(x1 > x2)
				xdif = x1 - x2;
			else 
				xdif = x2 - x1;
			if(y1 > y2)
				ydif = y1 - y2;
			else
				ydif = y2 - y1;
			
			dist = Math.sqrt(xdif*xdif+ydif*ydif);
			
		return dist;
		}
		
		*/

    @Override
    public void mouseClicked(MouseEvent e) {


    }

    @Override
    public void mousePressed(MouseEvent e) {
        //variable of type int that gets the coordinates of the mouse
        int mx = e.getX();
        int my = e.getY();

        //if the button is pressed within these boundaries then call the turning function
        if (mx > 800 - 780 && mx < 100 && my > 600 - 150 && my < 525) {

            Main.turnSend = true; //if true then the it's the next player's turn
        }

        //buy a road
        //if the mouse is pressed within these boundaries, then the confirmation window becomes true, i.e. pops up
        if (mx > 800 - 100 && mx < 800 && my > 600 - 120 && my < 600) {

            System.out.println("3");

            window = true; //the confirmation window pop-up
            window1 = true; //if window1 is true then the program will know that the this confirmation window addresses the road button
        }

            /*if the confirmation window of the road is on and the mouse coordinates are within the specified boundaries and if trading.BuyARoad becomes true,
            it means that the "yes" button has been pressed and so if roadactive becomes true and the player will be able to place a road on the map.
            At the same time, window and window1 become false because the confirmation window disappears*/
        if(window1 == true && mx > 280 && mx < 340 && my > 315 && my < 355){
            System.out.println("yes");
            if(trading.BuyARoad()==true){
                roadactive =true;
            }
            window = false;
            window1 = false;
        }

        //if the mouse has been pressed within these specified boundaries, then the "no" button has been pressed and so window and window1 become false because the confirmation window turns off.
        if (mx > 435 && mx < 545 && my > 315 && my < 355){
            System.out.println("No");
            window = false;
            window1 = false;
        }


        //buy a settlement
        //if the mouse is pressed within these boundaries, then the confirmation window becomes true, i.e. pops up
        if (mx > 800 - 100 && mx < 800 && my > 600 - 200 && my < 600 - 120) {
            System.out.println("2");
            window = true; //the confirmation window pop-up
            window2 = true; //if window2 is true then the program will know that the this confirmation window addresses the settlement button

        }

            /*if the confirmation window of the road is on and the mouse coordinates are within the specified boundaries and if trading.BuySettlement becomes true,
            it means that the "yes" button has been pressed and so if houseactive becomes true and the player will be able to place a settlement on the map.
            At the same time, window and window2 become false because the confirmation window disappears*/
        if(window2 == true && mx > 280 && mx < 340 && my > 315 && my < 355){
            System.out.println("yes");
            if(trading.BuySettlement()==true){
                houseactive =true;
            }

            window = false;
            window2 = false;
        }

        //if the mouse has been pressed within these specified boundaries, then the "no" button has been pressed and so window and window2 become false because the confirmation window turns off.
        if (mx > 435 && mx < 545 && my > 315 && my < 355){
            System.out.println("No");
            window = false;
            window2 = false;

        }


        //buy a city
        if (mx > 800 - 100 && mx < 800 && my > 600 - 280 && my < 600 - 200) {
            System.out.println("1");
            window = true;
            window3 = true;//if window3 is true then the program will know that the this confirmation window addresses the city button

        }

             /*if the confirmation window of the road is on and the mouse coordinates are within the specified boundaries and if trading.BuyCity becomes true,
            it means that the "yes" button has been pressed and so if townactive becomes true and the player will be able to place a city on the map.
            At the same time, window and window3 become false because the confirmation window disappears*/
        if(window3 == true && mx > 280 && mx < 340 && my > 315 && my < 355){
            System.out.println("yes");
            if(trading.BuyCity()==true){
                townactive =true;
            }
            window = false;
            window3 = false;
        }

        //if the mouse has been pressed within these specified boundaries, then the "no" button has been pressed and so window and window3 become false because the confirmation window turns off.
        if (mx > 435 && mx < 545 && my > 315 && my < 355){
            System.out.println("No");
            window = false;
            window3 = false;
        }

    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub

    }


}



