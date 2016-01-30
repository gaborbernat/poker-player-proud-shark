package org.leanpoker.player.rankers;

import org.junit.Test;
import org.leanpoker.player.domain.Card;
import org.leanpoker.player.domain.Suit;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class FlushRankerTest {
    @Test
    public void testRanker() {
        List<Card> cards = new ArrayList<>();

        cards.add(new Card(3, Suit.diamonds));
        cards.add(new Card(4, Suit.diamonds));
        cards.add(new Card(7, Suit.diamonds));
        cards.add(new Card(8, Suit.spades));
        cards.add(new Card(3, Suit.diamonds));
        cards.add(new Card(7, Suit.diamonds));

        RankerType ranker = new FlushRanker();
        assertEquals(500, ranker.getRank(cards));
    }

    @Test
    public void testFail() {
        List<Card> cards = new ArrayList<>();

        cards.add(new Card(3, Suit.diamonds));
        cards.add(new Card(4, Suit.diamonds));
        cards.add(new Card(7, Suit.spades));
        cards.add(new Card(8, Suit.spades));
        cards.add(new Card(3, Suit.diamonds));
        cards.add(new Card(7, Suit.diamonds));

        RankerType ranker = new FlushRanker();
        assertEquals(0, ranker.getRank(cards));
    }
}