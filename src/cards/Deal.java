package cards;

import java.util.*;

public class Deal {
	public static void main(String args[]) {
		List<List<Card>> listOfPlayersCards = new ArrayList<>();

		int numHands = 2;
		int cardsPerHand = 26;
		List<Card> deck = Card.newDeck();
		// System.out.println(deck.get(14).getCardValue());
		Collections.shuffle(deck);
		for (int i = 0; i < numHands; i++) {
			// System.out.println(deal(deck, cardsPerHand));
			listOfPlayersCards.add(deal(deck, cardsPerHand));
		}
	}

	public static ArrayList<Card> deal(List<Card> deck, int n) {
		int deckSize = deck.size();
		List<Card> handView = deck.subList(deckSize - n, deckSize);
		ArrayList<Card> hand = new ArrayList<Card>(handView);
		handView.clear();
		return hand;
	}
	
	
}
