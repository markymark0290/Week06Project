package warCardGame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;



public class Deck {
	
	private List<Card> cards = new ArrayList<Card>();
	
	
public Deck() {
	
		//I created two strings to combine all of the card names in a for loop
		
		String[] rank = {"2","3","4","5","6","7","8","9","10","Jack","Queen","King", "Ace"}; 
		String[] suits = {"Spades","Hearts","Clubs","Diamonds"};
		
		
		//Created all cares in the deck in the nested for loop below.
		for(int i = 0; i < rank.length; i++) {  
			for (int j = 0; j < suits.length; j++) {
				String name = rank[i] + " of " + suits[j];
				Card card = new Card(i+2, name);
				cards.add(card);
				
			}
		}
		
	}

public void shuffle() { //shuffles the deck.
	
	Collections.shuffle(cards);
	
}
	
public void describe() { //describes all cards in the deck
	for(Card card : cards)
	System.out.println(card.getName());
	
}

//draw method is used in the gamePlay method in the app class
public Card draw() {
	Card topCard = cards.get(0);
	cards.remove(0);
	return topCard;
}

public int length() {  //I created a length method to loop through the size a players had (see dealCards in App class)
	int newInt = cards.size();
	return newInt;
}

public List<Card> getCards() {
	return cards;
}

public void setCards(List<Card> cards) {
	this.cards = cards;
}
	


}
