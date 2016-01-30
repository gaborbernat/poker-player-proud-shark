package org.leanpoker.player.rankers;

import org.junit.Test;
import org.leanpoker.player.domain.Card;
import org.leanpoker.player.domain.Suit;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class NumberRankerTest {
    @Test
    public void testRanker() {
        List<Card> cards = new ArrayList<>();

        cards.add(new Card(3, Suit.diamonds));
        cards.add(new Card(4, Suit.clubs));
        cards.add(new Card(4, Suit.hearts));
        cards.add(new Card(3, Suit.spades));
        cards.add(new Card(4, Suit.clubs));

        NumberRanker ranker = new NumberRanker();
        assertEquals(312, ranker.getRank(cards));
    }
}