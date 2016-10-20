package cards;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import cards.Card.Rank;
import cards.Card.Suit;

public class Game {

	public static void main(String[] args) {
		List<Card> deck = Card.newDeck();

		Card club8 = deck.get(6);
		Card club8ver2 = new Card(Rank.EIGHT, Suit.CLUBS);
		System.out.println(club8ver2);

		Collections.shuffle(deck);

		System.out.println(deck);

		int rNum = new Random().nextInt(deck.size());
		Card rCard = deck.get(rNum);
		System.out.println(rCard);

		Rank c8Rank = club8ver2.rank();
		Rank rCRank = rCard.rank();

		Suit c8Suit = club8ver2.suit();
		Suit rCSuit = rCard.suit();
		
//		System.out.println(c8Suit);
	}

	public int getRankScore(Card card1, Card card2) {

		if (card1.rank().equals(card2.rank())) {
			return 5;
		} else if (Math.abs(card1.getCardValue() - card2.getCardValue()) <= 3) {
			return 4 - Math.abs(card1.getCardValue() - card2.getCardValue());
		} else {
			return 0;
		}
	}

	public int getSuitScore(Card card1, Card card2) {
		
		ArrayList<Suit> redS = new ArrayList<Card.Suit>();
		ArrayList<Suit> blackS = new ArrayList<Card.Suit>();
		
		blackS.add(Suit.CLUBS);
		blackS.add(Suit.SPADES);
		
		redS.add(Suit.HEARTS);
		redS.add(Suit.DIAMONDS);
		
		if (card1.suit() == card2.suit()) {
			return 3;
		} else if (blackS.contains(card1.suit()) && blackS.contains(card2.suit()) ) {
			return 2;
		} else if (redS.contains(card1.suit()) && redS.contains(card2.suit()) ) {
			return 2;
		} else {
			return 0;
		}
		
	

	}
	public int totalScore(Card card1, Card card2){
		
		
		int rankS = getRankScore(card1, card2);
		int suitS = getSuitScore(card1, card2);
		if (rankS == 5 && suitS == 3) {
			int bonus = 5;
			
			return rankS + suitS + bonus;
		}else {
			return rankS + suitS;
		
		}
	}

}
