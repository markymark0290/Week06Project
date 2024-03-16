package warCardGame;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		
		//I added a scanner to be able to add names and begin the program.
		Scanner scan = new Scanner(System.in);
		
		Deck deck = new Deck(); // Deck variable
		
		
		//Player variables	
		Player player1 = new Player();
		
		Player player2 = new Player();
		
	
		//Welcome message
		System.out.println("*****Welcome to war!!!*****");
		
		System.out.println("Please enter your names.");
		
		//Player name inputs.
		System.out.print("Player 1: ");
		player1.setName(scan.nextLine()); //setting the name using a scanner
		
		System.out.print("Player 2: ");
		player2.setName(scan.nextLine()); //setting the name using a scanner
		
		System.out.println ();
		
		deck.shuffle(); //shuffling the deck
		
		//This is where the game begins.  This shows that the inputs for the player names was updated successfully.
		System.out.println("Hello " + player1.getName() + " and " + player2.getName()+"!!!!");
		System.out.print("Are you ready for war?!  Type yes: ");
		
		String answer; //this string is used in the do loop below.
		
		//I created a do loop to run through my if statements until the player types yes. 
		do  {
			answer = scan.next();  //scanner to receive the player's answer.
			if (answer.toLowerCase().equals("yes")) { //conditional statement takes the answer from scanner and makes it lower case
				
				System.out.println("Ok let's play!");
				
				System.out.println();
		
				dealCards(deck, player1, player2); //This method deals the cards to player1 and player2 (see below)
		
				gamePlay(player1, player2, scan); //This method goes through each card flip and compares them
		
				declareWinner(player1, player2);  //This method declares a winner.
		
			}else {
				System.out.println("Ok I'll wait....");
				System.out.print("Type yes when you're ready: ");
			}
			}
		while (!answer.toLowerCase().equals("yes"));

	}
	
	
	
	public static void dealCards (Deck deck, Player player1, Player player2) {
		int counter = 0;  
			//setting an incrementer for a while loop.  A while loop was used so I could use the length 
			//method and not run into issues half way through with a for loop containing an incrementer.  
		
		List<Card> player1Hand = new ArrayList<Card>(); //creating a list to be able to pass a list to the player
		List<Card> player2Hand = new ArrayList<Card>();
		
		while (deck.length() > 0) {
			
			//using modulus 2 allows every other card to be dealt to each player in the if/else statement.
			if (counter % 2 == 0) { 
				player1Hand.add(player1.draw(deck));
				player1.setHand(player1Hand);
			}
			else {
				player2Hand.add(player2.draw(deck));
				player2.setHand(player2Hand);
				
			}
			counter++;
			
			
		}
	}
//	
	
	public static void gamePlay(Player player1, Player player2, Scanner scan) {
	
		int round = 1; //counter for round numbers
	
		
		for(int i = 26; i > 0; i--) {  //This for loop is used to loop through each round til all cards are used.
			System.out.println("****ROUND " + round + "****"); //round number declaration
			System.out.println();
			Card card1 = player1.flip();  //each player flips a card using the flip method in the Player class
			Card card2 = player2.flip();
			System.out.println(player1.getName() + " card: " + card1.getName()); //The cards are displayed after being flipped.
			System.out.println(player2.getName() + " card: " + card2.getName());
			
		
			
			if (card1.getValue() > card2.getValue()) {  //This if statement compares the values for the flipped cards.
				player1.incrementCard(); //Player 1's score is increased if they when.
				System.out.println();
				System.out.println(player1.getName() + " gets 1 point!"); //This is what is printed when player 1 wins.
			}else if 
				(card1.getValue() < card2.getValue()){
				player2.incrementCard(); //Player 2's score is increased if they when.
				System.out.println();
				System.out.println(player2.getName() + " gets 1 point!"); //This is what is printed when player 2 wins.
			}else { //This is what is printed for a war.
				System.out.println();
				System.out.println("***War!!***");
			}
		
			//I added this if/else statement because I had a scanner that would stop each round for user input.  This made the last round wouldn't
			//ask for input.  This really isn't needed at since I commented out the scanner for my final project.
			
			if (i == 1) { 
				System.out.println(); 
				System.out.println(player1.getName() + " score: " + player1.getScore()); //The Players' scores are displayed at the end.
				System.out.println(player2.getName() + " score: " + player2.getScore());
				System.out.println();
			}else { //This cycles through each round except the last.
			System.out.println();
			System.out.println(player1.getName() + " score: " + player1.getScore());//The Players' scores are displayed at the end.
			System.out.println(player2.getName() + " score: " + player2.getScore());
			System.out.println("*********************************");
			
			System.out.println();
		//	System.out.print("Enter a key to flip the next card:"); <-- I commented this line so the code won't stop each round
		//	String answer = scan.next(); <--any charater can be taken to advance.
			System.out.println();
			System.out.println();
			
			round++; //The variable round increments through each loop.
			}
		}				
	}
	
		
		
	public static void declareWinner (Player player1, Player player2) {
		//This if/else statement checks to see which player wins and displays the correct winner after the game is down.
		if(player1.getScore() > player2.getScore()) { 
						
			//The Players' final scores are displayed at the end.
			System.out.println(player1.getName() + " final score: " + player1.getScore());  //Final scores are printed.
			System.out.println(player2.getName() + " final score: " + player2.getScore());
			System.out.println("***" + player1.getName() + " is the winner!!!***");   //The winner is declared
		}else if (player1.getScore() < player2.getScore()) {
			System.out.println(player1.getName() + " final score: " + player1.getScore()); //Final scores are printed.
			System.out.println(player2.getName() + " final score: " + player2.getScore());
			System.out.println("***" + player2.getName() + " is the winner!!!***"); //The winner is declared
		}else {
			System.out.println(player1.getName() + " final score: " + player1.getScore()); //Final scores are printed.
			System.out.println(player2.getName() + " final score: " + player2.getScore());
			System.out.println("***It's a tie!***"); //The winner is declared
		} 
	
		
	
	}
}

