package fr.uga.l3miage.pc.prisonersdilemma.StrategiesTest;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import fr.uga.l3miage.pc.prisonersdilemma.enums.Decision;
import fr.uga.l3miage.pc.prisonersdilemma.Strategies.ToujoursCooperer;

class ToujoursCoopererTest {
    @Test
    void testExecute(){
        ToujoursCooperer tc = new ToujoursCooperer();
        Decision res = tc.execute(null, null);
        assertEquals(Decision.COOPERER,res);
    }
}
