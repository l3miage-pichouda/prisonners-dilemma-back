package fr.uga.l3miage.pc.prisonersdilemma.StrategiesTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import fr.uga.l3miage.pc.prisonersdilemma.enums.Decision;
import fr.uga.l3miage.pc.prisonersdilemma.Strategies.Aleatoire;

class AleatoireTest {
    @Test
    void testExecute() {
        Aleatoire aleatoire = new Aleatoire();
        Decision result = aleatoire.execute(null, null);
        assertEquals(Decision.COOPERER, result);
    }
}
