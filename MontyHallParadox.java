import java.util.Scanner;

/**This program simulates the Monty Hall Paradox in depth.
 */

public class MontyHallParadox {

	public static void main(String[] args) {
	 Scanner in = new Scanner(System.in);
	 int wonBySwitch = 0;
	 int wonByKeep = 0;
	 int keptChoice = 0;
	 int carPosition = 0;
	 int goatPosition = 0;
	 int playerChoice = 0;
	 int hostGoatPosition = 0;
	 int switchChoice = 0;
	 int switchCount = 0;
	 int won = 0;
	 
	 for(int i = 0; i < 1000; i++)
	 {
		carPosition = (int) (Math.random() * 3) + 1;
		goatPosition = (int) (Math.random() * 3) + 1;
		playerChoice = (int) (Math.random() * 3) + 1;
		hostGoatPosition = (int) (Math.random() * 3) + 1;
		
		while(goatPosition == carPosition) 
		{
			goatPosition = (int) (Math.random() * 3) + 1;
		}
		
		while(hostGoatPosition == carPosition) 
		{
			hostGoatPosition = (int) (Math.random() * 3) + 1;
			while(hostGoatPosition == playerChoice) 
				{
				hostGoatPosition = (int) (Math.random() * 3) + 1;
				}
		}
//		System.out.println(hostGoatPosition);
//		System.out.println(carPosition);
//		System.out.println(playerChoice);
		
		if (playerChoice == carPosition) {
			//player was lucky but didn't know
			hostGoatPosition = goatPosition;
			switchChoice = (int) (Math.random() * 2) + 1; // 1 for switch 2 for keep
			if (switchChoice == 1) {
				switchCount ++;
				}
			else {
				keptChoice ++;
				won ++;
				wonByKeep ++;
				}
		}
		else if(playerChoice == goatPosition) 
		{
			// player picked a goat by chance
			switchChoice = (int) (Math.random() * 2) + 1; // 1 for switch 2 for keep
			if (switchChoice == 1) {
				while (playerChoice == goatPosition) {
					playerChoice = (int) (Math.random() * 3) + 1;
				}
				if (playerChoice == carPosition) {
					wonBySwitch ++;
					won ++;
				}
				else {
				}
				switchCount ++;
				}
			else {
				keptChoice ++;
				}
		}
		else 
		{
			//Player chose another goat
			hostGoatPosition = goatPosition;
			switchChoice = (int) (Math.random() * 2) + 1;
			if (switchChoice == 1) {
				playerChoice = carPosition; // player won
				wonBySwitch ++;
				switchCount ++; 
				won ++;
				}
			else {
				keptChoice ++;
				}		 	 
		 } 
	 }	
	 
	System.out.printf("The player switched %d times. \n", switchCount);
	System.out.printf("The player kept their choice %d times. \n", keptChoice);
	System.out.printf("The player won %d times. \n", won);
	System.out.printf("The player won by switching %d times. \n", wonBySwitch);
	System.out.printf("The player won by keeping %d times. \n", wonByKeep);
	}

}
