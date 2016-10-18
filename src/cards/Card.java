package cards;

import java.util.*;

public class Card {
	
	public int getCardValue() {
		return rank().value;
	}
	
	public enum Rank {
			
		DEUCE(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9), TEN(10), JACK(11), QUEEN(12), KING(13), ACE(14);
		private int value;
		private Rank(int constValue) {
	         this.value = constValue;
	      }
			
	}

	public enum Suit {
		CLUBS, DIAMONDS, HEARTS, SPADES
	}

	private final Rank rank;
	private final Suit suit;

	Card(Rank rank, Suit suit) {
		this.rank = rank;
		this.suit = suit;
	}

	public Rank rank() {
		return rank;
	}

	public Suit suit() {
		return suit;
	}

	public String toString() {
		return rank + " of " + suit + "(" + rank.value + ")";
	}

	private static final List<Card> protoDeck = new ArrayList<Card>();

	static int temp;

	// Initialize prototype deck
	static {
		for (Suit suit : Suit.values())

			for (Rank rank : Rank.values())
				protoDeck.add(new Card(rank, suit));

	}

	public static ArrayList<Card> newDeck() {
		return new ArrayList<Card>(protoDeck); // Return copy of prototype deck
	}
}