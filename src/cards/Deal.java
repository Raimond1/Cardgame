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

		// System.out.println(listOfPlayersCards.get(1).size());

//		System.out.println(linnadePoletamine(listOfPlayersCards.get(0), listOfPlayersCards.get(1), "Janar", "Mark"));
		linnadePoletamineSeries(10, "Raimond", "Mark");
	}

	public static ArrayList<Card> deal(List<Card> deck, int n) {
		int deckSize = deck.size();
		List<Card> handView = deck.subList(deckSize - n, deckSize);
		ArrayList<Card> hand = new ArrayList<Card>(handView);
		handView.clear();
		return hand;
	}

	public static int linnadePoletamine(List<Card> cardsPlayer1, List<Card> cardsPlayer2, String player1,
			String player2) {

		int player1Score = 0;
		int player2Score = 0;
		int drawScore = 0;

		for (int i = 0; i < cardsPlayer1.size(); i++) {
			if (cardsPlayer1.get(i).getCardValue() > cardsPlayer2.get(i).getCardValue()) {
				player1Score++;
			} else if (cardsPlayer1.get(i).getCardValue() < cardsPlayer2.get(i).getCardValue()) {
				player2Score++;
			} else {
				drawScore++;
			}

		}
		System.out
				.println(player1 + " " + player1Score + " - " + player2Score + " " + player2 + "; draws: " + drawScore);
		if (player1Score > player2Score) {
			System.out.println("Võitis: " + player1);
			return 1;
		} else if (player1Score < player2Score) {
			System.out.println("Võitis: " + player2);
			return -1;
		} else {
			System.out.println("Oli viik");
			return 0;
		}

	}

	public static void linnadePoletamineSeries(int series, String player1, String player2) {
		int p1Score = 0;
		int p2Score = 0;
		
		
		for (int i = 0; i < series; i++) {
			List<Card> deck = Card.newDeck();
			Collections.shuffle(deck);
			//TODO mängime linnade põletamist ja loeme kokku, kes võitis (a.la
			// p1Score ++; )
			int result = linnadePoletamine(deal(deck, 26), deal(deck, 26), player1, player2);
			if ( result == 1) {
				p1Score++;
			} else if (result == -1) {
				p2Score++;
			}
			
		}
		if (p1Score > p2Score) {
			System.out.println("Seeria on võitudud " + player1);
		} else if (p1Score < p2Score) {
			System.out.println("Seeria on võitudud " + player2);
		} else {
			System.out.println("Seeria oli viigis");
		}
	}

}
