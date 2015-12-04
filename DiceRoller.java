
public class DiceRoller {
		
		//print the method for establishing the result
	
	public int Roll(){ //method needed to roll the dice in the game
		
		/*in this method the dice will be rolled
		 * So the point is to create a method that allows for two dice to be rolled
		 * Each die gets a number from 1 to 6. These values have to be random.
		 * Afterwards, these two values will be added together, creating a sum.
		 * The sum will be the result of the dice per roll.
		 * Two dice with values from 1 to 6 are used in order to be sure that once added, 7 will be the most common number (a function of the game)
		*/
		
		int die1, die2; //two dice variables are created 
		
		/*generating a random number:
		 * randomNum = minimum + (int)(Math.random()*maximum);
		 * Here, the minimum is 1 and the maximum is 6
		 */
		
		die1 = 1 + (int)(Math.random()*6);
		die2 = 1 + (int)(Math.random()*6);

		int sum = die1 + die2; 
		//adding the random value from die1 to the random value of die2
		//integers are used because dice are whole numbers
		//the sum can be any number between 2 and 12
		
		System.out.println(sum);
		
		return sum;
		
		
	}
}
