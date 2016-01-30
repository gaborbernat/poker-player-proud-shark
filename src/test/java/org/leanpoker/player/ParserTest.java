package org.leanpoker.player;

import com.google.gson.JsonElement;
import org.junit.Before;
import org.junit.Test;
import org.leanpoker.JsonTestHelper;

import java.util.List;

public class ParserTest extends JsonTestHelper {
    private JsonElement request;

    @Before
    public void parseJson() {
        request = getRequest("simpleRequest");
    }

    @Test
    public void testGetOurHand() throws Exception {
        List<Parser.Card> cards = Parser.getHand(request, "Bob");

    }

    @Test
    public void testGetPlayer() throws Exception {
        Parser.getPlayer(request, "Albert");
    }
}