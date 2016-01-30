package org.leanpoker.player.rankers;

import org.junit.Test;
import org.leanpoker.player.Parser;
import org.leanpoker.player.domain.Card;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class StraightRankerTest {
    @Test
    public void testRanker() {
        List<Card> cards = new ArrayList<>();

        cards.add(new Card(3, Parser.Suit.diamonds));
        cards.add(new Card(6, Parser.Suit.clubs));
        cards.add(new Card(4, Parser.Suit.hearts));
        cards.add(new Card(3, Parser.Suit.spades));
        cards.add(new Card(4, Parser.Suit.clubs));
        cards.add(new Card(5, Parser.Suit.clubs));
        cards.add(new Card(2, Parser.Suit.spades));

        RankerType ranker = new StraightRanker();
        assertEquals(420, ranker.getRank(cards));
    }

    @Test
    public void testNope() {
        List<Card> cards = new ArrayList<>();

        cards.add(new Card(3, Parser.Suit.diamonds));
        cards.add(new Card(6, Parser.Suit.clubs));
        cards.add(new Card(4, Parser.Suit.hearts));
        cards.add(new Card(2, Parser.Suit.spades));
        cards.add(new Card(9, Parser.Suit.clubs));
        cards.add(new Card(9, Parser.Suit.spades));
        cards.add(new Card(2, Parser.Suit.hearts));

        RankerType ranker = new StraightRanker();
        assertEquals(0, ranker.getRank(cards));
    }
}