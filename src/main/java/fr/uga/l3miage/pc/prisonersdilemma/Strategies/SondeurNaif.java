package fr.uga.l3miage.pc.prisonersdilemma.strategies;

import java.util.ArrayList;
import java.util.Random;

import fr.uga.l3miage.pc.prisonersdilemma.enums.Decision;
import fr.uga.l3miage.pc.prisonersdilemma.interfaces.Strategy;

public class SondeurNaif implements Strategy{
    private final Random random;

    public SondeurNaif() {
        this.random = new Random();
    }

    public SondeurNaif(Random random) {
        this.random = random;
    }

    @Override
    public Decision execute(ArrayList<Decision> historiqueJoueur1, ArrayList<Decision> historiqueJoueur2) {
        if (historiqueJoueur2.isEmpty()) {
            return Decision.COOPERER;
        }
        if (random.nextDouble() < 0.25) {
            return Decision.TRAHIR;
        }
        return historiqueJoueur2.get(historiqueJoueur2.size() - 1);
    }
}
