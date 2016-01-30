package org.leanpoker.player.rankers;

import org.junit.Test;
import org.leanpoker.player.domain.Card;
import org.leanpoker.player.domain.Suit;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class StraightRankerTest {
    @Test
    public void testRanker() {
        List<Card> cards = new ArrayList<>();

        cards.add(new Card(3, Suit.diamonds));
        cards.add(new Card(6, Suit.clubs));
        cards.add(new Card(4, Suit.hearts));
        cards.add(new Card(3, Suit.spades));
        cards.add(new Card(4, Suit.clubs));
        cards.add(new Card(5, Suit.clubs));
        cards.add(new Card(2, Suit.spades));

        RankerType ranker = new StraightRanker();
        assertEquals(420, ranker.getRank(cards));
    }

    @Test
    public void testNope() {
        List<Card> cards = new ArrayList<>();

        cards.add(new Card(3, Suit.diamonds));
        cards.add(new Card(6, Suit.clubs));
        cards.add(new Card(4, Suit.hearts));
        cards.add(new Card(2, Suit.spades));
        cards.add(new Card(9, Suit.clubs));
        cards.add(new Card(9, Suit.spades));
        cards.add(new Card(2, Suit.hearts));

        RankerType ranker = new StraightRanker();
        assertEquals(0, ranker.getRank(cards));
    }
}