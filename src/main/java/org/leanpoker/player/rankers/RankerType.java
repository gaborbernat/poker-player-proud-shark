package org.leanpoker.player.rankers;

import org.leanpoker.player.domain.Card;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by dell on 1/30/2016.
 */
public interface RankerType {
    public int getRank(List<Card> cards);
}
