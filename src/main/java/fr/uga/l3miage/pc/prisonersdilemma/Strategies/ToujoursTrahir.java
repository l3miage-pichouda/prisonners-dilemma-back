package fr.uga.l3miage.pc.prisonersdilemma.Strategies;


import java.util.ArrayList;

import fr.uga.l3miage.pc.prisonersdilemma.enums.Decision;
import fr.uga.l3miage.pc.prisonersdilemma.interfaces.Strategy;
import lombok.Getter;

@Getter
public class ToujoursTrahir implements Strategy {

    public Decision execute(ArrayList<Decision> historiqueJoueur1, ArrayList<Decision> historiqueJoueur2) {
        return Decision.TRAHIR;
    }
}