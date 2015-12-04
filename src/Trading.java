
public class Trading {
	
	int [] resources = new int [6]; // an array for storying resources and the number of resources
	
	// initializing the first line with the name of the resources
		public  Trading(){ //the constructor
			/*
			for(int i=0; i< 6; i++)
			{
				resources[i]=resource[i];
			}
			*/
		}
	    
	    public boolean BuyARoad(){ // checks if the player has enough resources for buying the road and updates the resources
		                           // if returns true if yes and false if no
		 if(Player.resources[2]>= 1 && Player.resources[3]>=1) { Player.resources[2]-= 1; // substracts one from the player's resources
		                                           Player.resources[3]-= 1; //substracts one from the player's resources
		                                           System.out.println("bought road"); // prints on the screen
		                                           return true;
		                                                           }

		 else return false;
	 }
	 
	 
	 public boolean BuySettlement() { // checks if the player has enough resources for buying the settlements and updates the resources
		 // it returns true if he can and false if not
		 if( Player.resources[0]>= 1 &&  Player.resources[0]>= 1 &&  Player.resources[3]>=1 &&  Player.resources[4]>=1)
		 {
			 Player.resources[0]-= 1;// substracts one from the player's resources
			 Player.resources[2]-= 1;// substracts one from the player's resources
			 Player.resources[3]-= 1;// substracts one from the player's resources
			 Player.resources[4]-= 1;// substracts one from the player's resources
			 Player.resources[5]+= 1;// adds one victory point
			 
			 System.out.println("bought a house");
			 
			 return true;
			 // checks if the player has enough resources for buying the settlements and updates the resources
		 }
		 else{
			 System.out.println("not bought"); 
	return false;
		 }
	 }
	 
	 public boolean BuyCity() {
		 
		 if( Player.resources[0]> 1 &&  Player.resources[1]>2) // checks if the player has enough resources for buying the city and updates the resources
		 {
			 Player.resources[0]-= 2; // substracts 2 from the player's resources
			 Player.resources[1]-= 3;// substracts 3 from the player's resources
			 Player.resources[5]+= 1;// adds one victory point
			return true;

		 }
		 else return false;
		 
	 }
	 /*
	 public void UpdateResources(int [] resource) {
	    for(int i=0; i<6; i++)
	    	
	    	{
	    		resource[i]= resources[i];
	    	}
	 }
	 */
}
	 
	 
	  
	    

