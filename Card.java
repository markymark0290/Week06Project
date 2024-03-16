package warCardGame;

public class Card {
	
	private int value;
	private String name;
	
	
	public Card(int value, String name) {
		super();
		this.value = value;
		this.name = name;
	}
	
	public void describe() {
		System.out.println("Card: " + name + "with a value of " + value);
	}


	public int getValue() {
		return value;
	}


	public void setValue(int value) {
		this.value = value;
	}


	public String getName() { //Used in gamePlay method in app class and the Deck class describe method
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
	
	
	

}
