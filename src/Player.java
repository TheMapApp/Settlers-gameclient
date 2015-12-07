import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Player{

	// this is the constructor for the player
	
	private int playerId; // decares a variable of the type int
	private boolean longestRoad; // declares a boolean variable
	private boolean Playersturn;// declares a boolean variable
	static Color _Playercolor= new Color(255,0,0); // declar a variavle of the type color
	static int [] resources= new int [6]; // an array that stores each player's resources and victory points




	public Player(int id)
	{
		playerId=id; // initializes the player's id
		resources[5]=0; // sets the victory points to 0
		setcolor(3);// set the color of the player
/*
		resources[0] = 2;//wheat- each player gets 2 of it
		resources[1] = 0;//stone - each player gets 2 of it
		resources[2] = 4;//brick - each player gets 2 of it
		resources[3] = 4;//wood - each player gets 2 of it
		resources[4] = 2;//sheep -each player gets 2 of it
		resources[5] = 0;//victory point- no victory points
*/
        resources[0] = 10;//wheat- each player gets 2 of it
        resources[1] = 10;//stone - each player gets 2 of it
        resources[2] = 10;//brick - each player gets 2 of it
        resources[3] = 10;//wood - each player gets 2 of it
        resources[4] = 10;//sheep -each player gets 2 of it
        resources[5] = 0;//victory point- no victory points

	}
	//this function initialize an array at the start of the game
	//on the last position the player has the victory 
	public void initializeResources()
	{
		for(int i=0;i<6;i++) {
			if(i==5) resources[i]=2;// at the  beginning of the game each player has 2 points
			else resources[i]=0; //
		}
	}
	//this function returns 1 if the player has reached the maximum number of points
	public int CheckWin(){
		
		if(resources[5]==10) return 1; 
		else return 0; // else return 0 wich means that the player doesn't have a victory ponints
		
	}
	//methods for checking if the player has the longest road
	
	/*public boolean checkLongestRoad() {
		return longestRoad;
	}
	public void changeLongestRoad() {
		
		if(longestRoad==true) { 
			longestRoad=false;
			resources[5]=-2;
		}
		else {
			longestRoad=true;
			resources[5]=+2;
		}
	} */
		
		public int getId (){
			return playerId;
		} // returns an integers wich represents the player's id
		
		public boolean checkPlayersTurn (int PlayersTurn){ // checks if is the player's turn
		
			 if (PlayersTurn==1) return true; // if it is returns true
			 else return false;// othewise returns false
	}


	public void paintPlayer(Graphics g){ // prints the resources on the window
        if(Main.gameStart) {
            g.setColor(Color.white); // sets the color of the font to white
            g.setFont(new Font("Cambria", Font.BOLD, 14)); // sets the font to cambria, bold, of the size 14
            g.drawString("Player " + Main.id + ":", 25, 25);// prints the text on the window
            g.drawString("Wheat: " + resources[0], 25, 40);// prints the text on the window
            g.drawString("Sheep: " + resources[4], 25, 55);// prints the text on the window
            g.drawString("Wood: " + resources[3], 25, 70);// prints the text on the window
            g.drawString("Brick: " + resources[2], 25, 85);// prints the text on the window
            g.drawString("Stone: " + resources[1], 25, 100);// prints the text on the window
            g.drawString("Points: " + resources[5], 25, 115);// prints the text on the window

        }

		if(resources[5]>=10){
			g.setFont(new Font("Cambria", Font.BOLD, 30));
			g.drawString("YOU WIN!!! CONGRATULATIONS: " , 150, 350);
		}
	}


	public static void setcolor(int k )
	{
		if(k == 1) {
			_Playercolor= new Color(232, 215, 45);
		}
		if(k == 2) {
			_Playercolor= new Color(199, 9, 72);
		}
		if(k == 3) {
			_Playercolor= new Color(0, 46, 199);
		}
		if(k == 4) {
			_Playercolor= new Color(12, 190, 199);
		}
	}


}
	
	

    

