package fr.uga.l3miage.pc.prisonersdilemma.modules;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import fr.uga.l3miage.pc.prisonersdilemma.enums.Decision;
import fr.uga.l3miage.pc.prisonersdilemma.enums.TypeStrategy;
import fr.uga.l3miage.pc.prisonersdilemma.interfaces.Strategy;
import fr.uga.l3miage.pc.prisonersdilemma.strategies.StrategyFactory;






public class PartieTest {

    private Partie partie;
    private StrategyFactory strategyFactory;

    @BeforeEach
    public void setUp() {
        strategyFactory = Mockito.mock(StrategyFactory.class);
        partie = new Partie(5);
        partie.setStrategyFactory(strategyFactory);
    }

    @Test
    public void testAddJoueur() {
        Mockito.when(strategyFactory.create(TypeStrategy.TOUJOURS_COOPERER)).thenReturn(Mockito.mock(Strategy.class));
        partie.addJoueur("Player1", true, TypeStrategy.TOUJOURS_COOPERER);
        assertEquals(1, partie.getNbJoueurs());
        assertEquals("Player1", partie.getJoueurs().get(0).getName());
    }

    @Test
    public void testAddJoueurWithEmptyName() {
        Exception exception = assertThrows(IllegalStateException.class, () -> {
            partie.addJoueur("", true, TypeStrategy.TOUJOURS_COOPERER);
        });
        assertEquals("Le nom du joueur ne peut pas être vide.", exception.getMessage());
    }

    @Test
    public void testAddJoueurWithDuplicateName() {
        Mockito.when(strategyFactory.create(TypeStrategy.TOUJOURS_COOPERER)).thenReturn(Mockito.mock(Strategy.class));
        partie.addJoueur("Player1", true, TypeStrategy.TOUJOURS_COOPERER);
        Exception exception = assertThrows(IllegalStateException.class, () -> {
            partie.addJoueur("Player1", true, TypeStrategy.TOUJOURS_COOPERER);
        });
        assertEquals("Le nom du joueur est déjà utilisé.", exception.getMessage());
    }

    @Test
    public void testAbandonner() {
        Mockito.when(strategyFactory.create(TypeStrategy.TOUJOURS_COOPERER)).thenReturn(Mockito.mock(Strategy.class));
        partie.addJoueur("Player1", true, TypeStrategy.TOUJOURS_COOPERER);
        Joueur joueur = partie.getJoueurs().get(0);
        partie.abandonner(joueur, TypeStrategy.TOUJOURS_COOPERER);
        assertFalse(joueur.isConnected());
    }

    @Test
    public void testSoumettreDecision() {
        Mockito.when(strategyFactory.create(TypeStrategy.TOUJOURS_COOPERER)).thenReturn(Mockito.mock(Strategy.class));
        partie.addJoueur("Player1", true, TypeStrategy.TOUJOURS_COOPERER);
        partie.addJoueur("Player2", true, TypeStrategy.TOUJOURS_COOPERER);
        boolean result = partie.soumettreDecision("Player1", Decision.COOPERER);
        assertTrue(result);
        assertEquals(Decision.COOPERER, partie.getJoueurs().get(0).getDecision());
    }

    @Test
    public void testProcessRound() {
        Mockito.when(strategyFactory.create(TypeStrategy.TOUJOURS_COOPERER)).thenReturn(Mockito.mock(Strategy.class));
        partie.addJoueur("Player1", true, TypeStrategy.TOUJOURS_COOPERER);
        partie.addJoueur("Player2", true, TypeStrategy.TOUJOURS_COOPERER);
        partie.soumettreDecision("Player1", Decision.COOPERER);
        partie.soumettreDecision("Player2", Decision.COOPERER);
        assertEquals(3, partie.getJoueurs().get(0).getScore());
        assertEquals(3, partie.getJoueurs().get(1).getScore());
    }


    @Test
    public void testGetDecisionOfOtherPlayer() {
        Mockito.when(strategyFactory.create(TypeStrategy.TOUJOURS_COOPERER)).thenReturn(Mockito.mock(Strategy.class));
        partie.addJoueur("Player1", true, TypeStrategy.TOUJOURS_COOPERER);
        partie.addJoueur("Player2", true, TypeStrategy.TOUJOURS_COOPERER);
        partie.soumettreDecision("Player1", Decision.COOPERER);
        assertTrue(partie.getDecisionOfOtherPlayer("Player2"));
    }

    @Test
    public void testGetHistorique() {
        Mockito.when(strategyFactory.create(TypeStrategy.TOUJOURS_COOPERER)).thenReturn(Mockito.mock(Strategy.class));
        partie.addJoueur("Player1", true, TypeStrategy.TOUJOURS_COOPERER);
        partie.soumettreDecision("Player1", Decision.COOPERER);
        assertEquals(1, partie.getHistorique("Player1").size());
    }

    @Test
    public void testResetDecisions() {
        Mockito.when(strategyFactory.create(TypeStrategy.TOUJOURS_COOPERER)).thenReturn(Mockito.mock(Strategy.class));
        partie.addJoueur("Player1", true, TypeStrategy.TOUJOURS_COOPERER);
        partie.addJoueur("Player2", true, TypeStrategy.TOUJOURS_COOPERER);
        partie.soumettreDecision("Player1", Decision.COOPERER);
        partie.soumettreDecision("Player2", Decision.COOPERER);
        partie.resetDecisions();
        assertNull(partie.getJoueurs().get(0).getDecision());
        assertNull(partie.getJoueurs().get(1).getDecision());
    }
}