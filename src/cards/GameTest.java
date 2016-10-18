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
}
