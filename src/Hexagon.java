import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

public class Hexagon extends JPanel implements MouseListener {

    static int[] resType = new int[21];
    public int colCode;
    public int aux = 0;
	static int pmx=0;
	static int pmy=0;


	int rolled =0;
	int diceval;
	// the posistion of each hexagon
	int _posx;
	int _posy;
	boolean itson = false;
	boolean itsontown = false;
	Color _color = new Color(0, 100, 0);
	Color _color2 = new Color(0, 0, 0);

	// arrays filled with x and y vaules of the hexagon points
	int[] shapex = new int[6];
	int[] shapey = new int[6];

	Image image;
	int r = 57;
	Middlepoint[] middlearray = new Middlepoint[6];
	  
	  Color brick = new Color (152, 0, 0);
	  Color wood = new Color (0, 102, 0);
	  Color stone = new Color (115, 115, 115);
	  Color wheat = new Color (247, 244, 57);
	  Color sheep = new Color (102, 255, 102);
	  Color desert = new Color (235, 177, 54);

	Hexagon(int posx, int posy) {

		_posy = posy;
		_posx = posx;

		// filles in the posisition of the points
		for (int i = 0; i < 6; i++) {
			shapex[i] = ((int) (_posy + r * Math.cos(i * 2 * Math.PI / 6)));
			shapey[i] = (int) (_posx + r * Math.sin(i * 2 * Math.PI / 6));
		}
		
		// initialises the corner points
		for (int b = 0; b < 6; b++) {
			middlearray[b] = new Middlepoint(shapex[b] - 5, shapey[b] - 5);
					}	
	}

	@Override
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;

		for (int l = 0; l < 6; l++) {
			for (int i = 0; i < 10; i++) {
				if (Grid.hus[i] != null) {
					if (dist(Grid.hus[i]._xpos, shapex[l], Grid.hus[i]._ypos, shapey[l]) <= 20 &&Grid.hus[i].myhouse == true ) {
						itson = true;
					}
				}
			}
		}

		for (int l = 0; l < 6; l++) {
			for (int i = 0; i < 10; i++) {
				if (Grid.by[i] != null) {
					if (dist(Grid.by[i]._xpos, shapex[l], Grid.by[i]._ypos, shapey[l]) <= 20 &&Grid.by[i].myTown == true) {
						itsontown = true;
					}
				}
			}
		}


		for (int l = 0; l < 6; l++) {
			for (int i = 0; i < 10; i++) {
				if (Grid.hus[i] != null) {
					if (dist(Grid.hus[i]._xpos, shapex[l], Grid.hus[i]._ypos, shapey[l]) <= 80) {
						middlearray[l].occupied = true;

					}
				}
			}
		}

		for (int l = 0; l < 6; l++) {
			for (int i = 0; i < 10; i++) {
				if (Grid.enemyhus[i] != null) {
					if (dist(Grid.enemyhus[i]._xpos, shapex[l], Grid.enemyhus[i]._ypos, shapey[l]) <= 80) {
						middlearray[l].occupied = true;

					}
				}
			}
		}

		//dicechecker




		// draws the hexagon
		g.setColor(_color2);
		g2.setStroke(new BasicStroke(3));
		g.drawPolygon(shapex, shapey, 6);

/*
		if (itsontown == true ) {
			g.setColor(_color);// sets the color to green
			g.fillPolygon(shapex, shapey, 6);// colors the hexagon
		} else if (itson == true) {
				g.setColor( new Color(199, 21, 197)); // sets the color to black
				g.fillPolygon(shapex, shapey, 6); // colors the hexagon
			}*/


			if(colCode==1){ // if the number from the server is 1
				g.setColor(wheat); // sets the color to yellow
			}
			if(colCode==2){ // if the number from the server is 2
				g.setColor(stone);// sets the color to grey
			}
			if(colCode==3){ // if the number from the server is 3
				g.setColor(brick);// sets the color to red
			}
			if(colCode==4){ // if the number from the server is 4
				g.setColor(wood);//sets the color to green
			}
			if(colCode==5){ // if the number from the server is 5
				g.setColor(sheep);// sets the color to light green
			}


			g.fillPolygon(shapex, shapey, 6); // colors the hexagon



		for (int b = 0; b < 6; b++) {
			middlearray[b].paint(g);


			for (int i = 0; i < 10; i++) {
				if (Grid.hus[i] != null) {
					Grid.hus[i].paint(g);
				}
			}
				for (int i = 0; i < 10; i++) {
					if (Grid.enemyhus[i] != null) {
						Grid.enemyhus[i].paint(g);
					}
			}
				for (int i = 0; i < 10; i++) {
					if (Grid.by[i] != null) {
						Grid.by[i].paint(g);
					}

				}
				for (int i = 0; i < 10; i++) {
					if (Grid.vej[i] != null) {
						Grid.vej[i].paint(g);
					}
				}
			}
			g.drawImage(image, _posy - 20, _posx - 20, null);

		}

	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {
		int mx = e.getX();
		int my = e.getY();

		if (Main.turn == true) {
			///++++++housebuyer+++++/////
			double disthouse;

				if (Buying.houseactive) {

					if (Grid.housecounter < 2) {


						//checks if you are pressing a cornerpoint
						for (int l = 0; l < 6; l++) {

							if (dist(mx, shapex[l], my, shapey[l]) <= 20 && middlearray[l].occupied== false ) {


								Grid.hus[Grid.housecounter] = new House(mx, my, 1);
								Grid.hus[Grid.housecounter].myhouse = true;
								middlearray[l].setlamp2(true);
								middlearray[l].setlamp(true);
								System.out.println("house placed on grid");

								Main.houseTempX = Grid.hus[Grid.housecounter]._xpos;
								Main.houseTempY = Grid.hus[Grid.housecounter]._ypos;
								Main.houseSend = true;
								Grid.housecounter += 1;
								Buying.houseactive = false;
							}
						}


					} else {
						//checks if you are pressing a cornerpoint
						for (int l = 0; l < 6; l++) {

							if (dist(mx, shapex[l], my, shapey[l]) <= 20 && middlearray[l]._lamp == true  && middlearray[l].occupied== false) {


								Grid.hus[Grid.housecounter] = new House(mx, my, 1);
								Grid.hus[Grid.housecounter].myhouse = true;
								middlearray[l].setlamp2(true);
								middlearray[l].setlamp(true);
								System.out.println("house placed on grid");

								Main.houseTempX = Grid.hus[Grid.housecounter]._xpos;
								Main.houseTempY = Grid.hus[Grid.housecounter]._ypos;
								Main.houseSend = true;
								Grid.housecounter += 1;
								Buying.houseactive = false;
							}
						}
					}
				}




            ///++++++housebuyer+++++/////


            ///++++++townbuyer+++++/////
            if (Buying.townactive) {
                //checks if you are pressing a cornerpoint
                for (int l = 0; l < 6; l++) {

                    if (dist(mx, shapex[l], my, shapey[l]) <= 20 && middlearray[l]._lamp2 == true) {

                        Grid.by[Grid.towncounter] = new Town(mx, my);
						Grid.by[Grid.towncounter].myTown = true;
                        System.out.println("town placed on grid at" + mx + "," + my);

                        //Main.houseTempX = Grid.hus[Grid.housecounter]._xpos;
                        //Main.houseTempY = Grid.hus[Grid.housecounter]._ypos;
                        //Main.houseSend = true;

                        //Main.townTempX = Grid.by[Grid.towncounter]._xpos;
                        //Main.townTempY = Grid.by[Grid.towncounter]._ypos;
                        Main.townTempX = Grid.by[Grid.towncounter]._xpos;
                        Main.townTempY = Grid.by[Grid.towncounter]._ypos;
                        Main.townSend = true;
                        Grid.towncounter += 1;
                        Buying.townactive = false;
                    }
                }
            }
            ///++++++townbuyer+++++/////

            ///+++roadbuyer+++////
            if (Buying.roadactive) {

                //System.out.println(""+mx+"  "+ pmx+"  " +"  "+ my+"  "+ pmy+"" );
                if (pmx != 0) {
                    System.out.println(dist(mx, pmx, my, pmy));
                }
                for (int l = 0; l < 6; l++) {

                    if (dist(mx, shapex[l], my, shapey[l]) <= 20 && middlearray[l]._lamp == true && pmx == 0) {
                        pmx = shapex[l];
                        pmy = shapey[l];
                        System.out.println("first point set");
                        middlearray[l].setlamp2(true);

                    } else if (dist(mx, pmx, my, pmy) <= 70 && dist(mx, pmx, my, pmy) >= 30 && dist(mx, shapex[l], my, shapey[l]) <= 20) {
                        Grid.vej[Grid.roadcounter] = new Road(pmx, pmy, mx, my);
                        System.out.println("second point set");
                        middlearray[l].setlamp(true);
                        middlearray[l].setlamp2(false);
                        pmx = 0;
                        pmy = 0;

                        Main.roadTempX1 = Grid.vej[Grid.roadcounter]._xpos;
                        Main.roadTempX2 = Grid.vej[Grid.roadcounter]._xpos2;
                        Main.roadTempY1 = Grid.vej[Grid.roadcounter]._ypos;
                        Main.roadTempY2 = Grid.vej[Grid.roadcounter]._ypos2;
                        Main.roadSend = true;
                        Grid.roadcounter += 1;

                        Buying.roadactive = false;


                    }

                }
            }


            ///+++roadbuyer+++////


            Grid.updater = true;
            // System.out.println("hey"+Grid.updater);
        }
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public boolean housedist(int x1, int x2) {
		for (int k = 0; k < Grid.housecounter; k++) {
if(Grid.housecounter==0){

	return true;
}
			 if (dist(x1,Grid.hus[k]._xpos,x2,Grid.hus[k]._ypos)>40) {
				return true;
			}
		}
		return false;
	}


	public double dist(int x1, int x2, int y1, int y2) {
		double dist;
		float xdif;
		float ydif;

		if (x1 > x2)
			xdif = x1 - x2;
		else
			xdif = x2 - x1;
		if (y1 > y2)
			ydif = y1 - y2;
		else
			ydif = y2 - y1;

		dist = Math.sqrt(xdif * xdif + ydif * ydif);

		return dist;
	}


	public int returnNoFromServer() { // returns a number from the server
            int number = 0; // initializes an integer with 0;
            number = resType[aux]; // stores in number the value from aux position from resType array
            aux += 1;// increments aux with 1
        //if(aux > 18) aux = 0;
		return number; // return the number
	}
	
	

}
