package fr.uga.l3miage.pc.prisonersdilemma.StrategiesTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import fr.uga.l3miage.pc.prisonersdilemma.enums.Decision;
import fr.uga.l3miage.pc.prisonersdilemma.Strategies.ToujoursTrahir;

class ToujoursTrahirTest {
    @Test
    void testExecute(){
        ToujoursTrahir tt = new ToujoursTrahir();
        Decision res = tt.execute(null, null);
        assertEquals(Decision.TRAHIR,res);
    }
}
