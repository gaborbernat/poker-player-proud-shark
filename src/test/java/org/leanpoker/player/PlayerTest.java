package org.leanpoker.player;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import org.junit.Test;
import org.leanpoker.JsonTestHelper;

import static org.junit.Assert.assertEquals;

public class PlayerTest extends JsonTestHelper {

    @Test
    public void testBetRequest() throws Exception {
        JsonElement jsonElement = getRequest("proudSharkPassive");
        assertEquals(0, Player.betRequest(jsonElement));
    }
}
