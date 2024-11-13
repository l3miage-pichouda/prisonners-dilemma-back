package fr.uga.l3miage.pc.prisonersdilemma.Strategies;

import java.util.ArrayList;

import fr.uga.l3miage.pc.prisonersdilemma.enums.Decision;
import fr.uga.l3miage.pc.prisonersdilemma.interfaces.Strategy;

public class DonnantPourDeuxDonnantsEtAleatoire implements Strategy {

    @Override
    public Decision execute(ArrayList<Decision> historiqueJoueur1, ArrayList<Decision> historiqueJoueur2) {
        return Decision.COOPERER;
    }
}