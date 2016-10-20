package cards;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Test;

import cards.Card.Rank;
import cards.Card.Suit;

public class GameTest {

	@Test
	public void cardsWithSameRankGet5Points(){
		Game game = new Game();
		Card club8 = new Card(Rank.EIGHT, Suit.CLUBS);
		Card dia8 = new Card(Rank.EIGHT, Suit.DIAMONDS);
		game.getRankScore(club8, dia8);
		assertThat(game.getRankScore(club8, dia8), is(5));
		
	}
	@Test
	public void cardsWithSameSuitGet3Points(){
		Game game = new Game();
		Card club8 = new Card(Rank.EIGHT, Suit.CLUBS);
		Card clubA = new Card(Rank.ACE, Suit.CLUBS);
		assertThat(game.getSuitScore(club8, clubA), is(3));
		
	}
	@Test
	public void cardsWithSameSuitColorGet2Points(){
		Game game = new Game();
		Card club8 = new Card(Rank.EIGHT, Suit.CLUBS);
		Card spadeA = new Card(Rank.ACE, Suit.SPADES);
		assertThat(game.getSuitScore(club8, spadeA), is(2));
		
	}
	@Test
	public void getTotalScore(){
		Game game = new Game();
		Card club8 = new Card(Rank.EIGHT, Suit.CLUBS);
		Card spadeA = new Card(Rank.ACE, Suit.SPADES);
		Card spade9 = new Card(Rank.NINE, Suit.SPADES);
		
		
		assertThat(game.totalScore(club8, club8), is(13));
	}
}
