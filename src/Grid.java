import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

public class Grid {

    //global variables
    static boolean arrayReceived = false;
    static int[] shuffledArray = new int[18]; //shuffled array of the numbers for the hexagons on the grid

    //variables of type integer
    int _i;
    int _k;

    //variable of type boolean needed for being able to not update the grid continuously
    static boolean updater = false;

    //static variables of type array which hold all the road, settlements, cities, but also the enemy houses
    public static House[] hus = new House[20];
    public static House[] enemyhus = new House[20];
    public static Town[] by = new Town[20];
    public static Road[] vej = new Road[20];

    //static vairbales of type integer which count how many road, settlements and cities there are in the game
    static int housecounter = 0;
    static int enemyhousecounter = 0;
    static int towncounter = 0;
    static int roadcounter = 0;

    //2D array holding the hexagons needed for the grid
    public Hexagon[][] hexarray = new Hexagon[5][5];

    //array holding the images with numbers printed on the grid
    public static ImageIcon[] numbers = new ImageIcon[19];

    //variable of type integer which counts the pictures
    int p = 0;

    //variable of type integer which determines how many resources the player get: 1 for settlement, 2 for city
    int resourcelvl = 1;


    //constructor
    Grid(int i, int k) {

        //variables needed for position of hexagons
        _i = i;
        _k = k;

    }

    // makes the pattern and fills the hexagons into the 2d array
    public void fill() {

        if (arrayReceived) {

            //each of these for-loops takes care of placing a different number of hexagons in a line
            for (int r = 0; r < 3; r++) {
                hexarray[0][r] = new Hexagon((r * 50 + _i) * 2, (_k) * 2); //places 3 hexagons in a slightly diagonal line
            }
            for (int r = 0; r < 4; r++) {
                hexarray[1][r] = new Hexagon((r * 50 + _i - 25) * 2, (_k + 43) * 2); //places 4 hexagons in a slightly diagonal line
            }
            for (int r = 0; r < 5; r++) {
                hexarray[2][r] = new Hexagon((r * 50 + _i - 50) * 2, (_k + 86) * 2); //places 5 hexagons in a slightly diagonal line
            }
            for (int r = 0; r < 4; r++) {
                hexarray[3][r] = new Hexagon((r * 50 + _i - 25) * 2, (_k + 129) * 2); //places 4 hexagons in a slightly diagonal line
            }
            for (int r = 0; r < 3; r++) {
                hexarray[4][r] = new Hexagon((r * 50 + _i) * 2, (_k + 172) * 2); //places 3 hexagons in a slightly diagonal line
            }


            //for-loop used for getting the directory of all the 18 images with numbers on them
            for (int n = 0; n < 19; n++) {
                numbers[n] = new ImageIcon("images/" + n + ".png");
            }


            //nested for-loop which recognizes the position of the hexagon and the grid as a whole since the hexagons are not connected to each other
            for (int n = 0; n < 5; n++) {


                for (int k = 0; k < 5; k++) {
                    if (hexarray[n][k] != null) {

                        hexarray[n][k].image = numbers[shuffledArray[p]].getImage();
                        hexarray[n][k].diceval = shuffledArray[p];
                        hexarray[n][k].colCode = Hexagon.resType[p];
                        p = p + 1;//counts the pictures and adds 1 to the hexagons
                        //when the pictures got to 18 or passed, the program will only print the 18th number
                        if (p >= 18) {
                            p = 18;
                        }
                    }
                }
            }

        }
        updater = true;
    }


    public void resourcedister() {


        //nested for-loop which recognizes the position of the hexagon and the grid as a whole since the hexagons are not connected to each other
        for (int n = 0; n < 5; n++) {


            for (int k = 0; k < 5; k++) {
                if (hexarray[n][k] != null) {

                    //this is the system that awards resources if the dice roll is the same as any of the numbers on the tiles
                    if (hexarray[n][k].itson == true || hexarray[n][k].itsontown == true) {
                        if (hexarray[n][k].itson == true) {
                            resourcelvl = 1;
                        } if (hexarray[n][k].itsontown == true) {
                            resourcelvl = 2;
                        }


                        if (Main.roll == 2 && hexarray[n][k].diceval == 1) { //if the dice roll is equal to 2 and the number on the hexagon is 2
                            Player.resources[hexarray[n][k].colCode - 1] += resourcelvl; //then award the player a resource or two, corresponding to that particular hexagon tile
                        } else if (Main.roll == 3 && hexarray[n][k].diceval == 2) { //if the dice roll is equal to 3 and the number on the hexagon is 3
                            Player.resources[hexarray[n][k].colCode - 1] += resourcelvl; //then award the player a resource or two, corresponding to that particular hexagon tile
                        } else if (Main.roll == 3 && hexarray[n][k].diceval == 3) { //if the dice roll is equal to 3 and the number on the hexagon is 3
                            Player.resources[hexarray[n][k].colCode - 1] += resourcelvl; //then award the player a resource or two, corresponding to that particular hexagon tile
                        } else if (Main.roll == 4 && hexarray[n][k].diceval == 4) { //if the dice roll is equal to 4 and the number on the hexagon is 4
                            Player.resources[hexarray[n][k].colCode - 1] += resourcelvl; //then award the player a resource or two, corresponding to that particular hexagon tile
                        } else if (Main.roll == 4 && hexarray[n][k].diceval == 5) { //if the dice roll is equal to 4 and the number on the hexagon is 4
                            Player.resources[hexarray[n][k].colCode - 1] += resourcelvl; //then award the player a resource or two, corresponding to that particular hexagon tile
                        } else if (Main.roll == 5 && hexarray[n][k].diceval == 6) { //if the dice roll is equal to 5 and the number on the hexagon is 5
                            Player.resources[hexarray[n][k].colCode - 1] += resourcelvl; //then award the player a resource or two, corresponding to that particular hexagon tile
                        } else if (Main.roll == 5 && hexarray[n][k].diceval == 7) { //if the dice roll is equal to 5 and the number on the hexagon is 5
                            Player.resources[hexarray[n][k].colCode - 1] += resourcelvl; //then award the player a resource or two, corresponding to that particular hexagon tile
                        } else if (Main.roll == 6 && hexarray[n][k].diceval == 8) { //if the dice roll is equal to 6 and the number on the hexagon is 6
                            Player.resources[hexarray[n][k].colCode - 1] += resourcelvl; //then award the player a resource or two, corresponding to that particular hexagon tile
                        } else if (Main.roll == 6 && hexarray[n][k].diceval == 9) { //if the dice roll is equal to 6 and the number on the hexagon is 6
                            Player.resources[hexarray[n][k].colCode - 1] += resourcelvl; //then award the player a resource or two, corresponding to that particular hexagon tile
                        } else if (Main.roll == 8 && hexarray[n][k].diceval == 10) { //if the dice roll is equal to 8 and the number on the hexagon is 8
                            Player.resources[hexarray[n][k].colCode - 1] += resourcelvl; //then award the player a resource or two, corresponding to that particular hexagon tile
                        } else if (Main.roll == 8 && hexarray[n][k].diceval == 11) { //if the dice roll is equal to 8 and the number on the hexagon is 8
                            Player.resources[hexarray[n][k].colCode - 1] += resourcelvl; //then award the player a resource or two, corresponding to that particular hexagon tile
                        } else if (Main.roll == 9 && hexarray[n][k].diceval == 12) { //if the dice roll is equal to 9 and the number on the hexagon is 9
                            Player.resources[hexarray[n][k].colCode - 1] += resourcelvl; //then award the player a resource or two, corresponding to that particular hexagon tile
                        } else if (Main.roll == 9 && hexarray[n][k].diceval == 13) { //if the dice roll is equal to 9 and the number on the hexagon is 9
                            Player.resources[hexarray[n][k].colCode - 1] += resourcelvl; //then award the player a resource or two, corresponding to that particular hexagon tile
                        } else if (Main.roll == 10 && hexarray[n][k].diceval == 14) { //if the dice roll is equal to 10 and the number on the hexagon is 10
                            Player.resources[hexarray[n][k].colCode - 1] += resourcelvl; //then award the player a resource or two, corresponding to that particular hexagon tile
                        } else if (Main.roll == 10 && hexarray[n][k].diceval == 15) { //if the dice roll is equal to 10 and the number on the hexagon is 10
                            Player.resources[hexarray[n][k].colCode - 1] += resourcelvl; //then award the player a resource or two, corresponding to that particular hexagon tile
                        } else if (Main.roll == 11 && hexarray[n][k].diceval == 16) { //if the dice roll is equal to 11 and the number on the hexagon is 11
                            Player.resources[hexarray[n][k].colCode - 1] += resourcelvl; //then award the player a resource or two, corresponding to that particular hexagon tile
                        } else if (Main.roll == 11 && hexarray[n][k].diceval == 17) { //if the dice roll is equal to 11 and the number on the hexagon is 11
                            Player.resources[hexarray[n][k].colCode - 1] += resourcelvl; //then award the player a resource or two, corresponding to that particular hexagon tile
                        } else if (Main.roll == 12 && hexarray[n][k].diceval == 18) { //if the dice roll is equal to 12 and the number on the hexagon is 12
                            Player.resources[hexarray[n][k].colCode - 1] += resourcelvl; //then award the player a resource or two, corresponding to that particular hexagon tile
                        }
                    }
                }
            }
        }
    }
}


	
	


