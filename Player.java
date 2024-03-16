package warCardGame;

import java.util.ArrayList;
import java.util.List;

public class Player {
	
	private List<Card> hand = new ArrayList<Card>();
	private int score;
	private String name;
	
	
	public Player() {
		
		score = 0;
	}



	public void describe() {
		System.out.println("Player name: " + name);
		System.out.println("Player " + name + " score: " + score);
		System.out.print("Player " + name + " hand: ");
		for(int i = 0; i < hand.size(); i++) {
			if (i != hand.size()-1) {
				System.out.print(hand.get(i).getName() + ", ");
			}else {
				System.out.println(hand.get(i).getName());
			}
		}
	}
	
	public Card flip () {
		
		Card topCard = hand.get(0);
		
		hand.remove(0);
		
		
		return topCard;
	}
	
	public Card draw (Deck newDeck) {
		
		Card drawCard = newDeck.draw();
		
		return drawCard;
		
		
	}
	
	public void incrementCard () {
		score++;
	}



	public List<Card> getHand() {
		return hand;
	}



	public void setHand(List<Card> hand) { //used in the dealCards method in the App class.
		this.hand = hand;
	}



	public int getScore() {  //get score used in multiple methods to display the score.
		return score;
	}



	public void setScore(int score) { //this is increased during the gamePlay method as the players win each round.
		this.score = score;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {  //used at the beginning with a scanner to create the player names.
		this.name = name;
	}
	
	
	
	
}
