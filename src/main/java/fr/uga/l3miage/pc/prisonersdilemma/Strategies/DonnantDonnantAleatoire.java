package fr.uga.l3miage.pc.prisonersdilemma.strategies;

import java.util.ArrayList;

import fr.uga.l3miage.pc.prisonersdilemma.enums.Decision;
import fr.uga.l3miage.pc.prisonersdilemma.interfaces.Strategy;
import lombok.Getter;


@Getter
public class DonnantDonnantAleatoire implements Strategy {

    @Override
    public Decision execute(ArrayList<Decision> historiqueJoueur1, ArrayList<Decision> historiqueJoueur2) {
        if (historiqueJoueur2.isEmpty()) {
            return Decision.COOPERER;
        }
        if (Math.random() < 0.5) {
            return Decision.COOPERER;
        }
        return historiqueJoueur2.get(historiqueJoueur2.size() - 1);
    }
}
