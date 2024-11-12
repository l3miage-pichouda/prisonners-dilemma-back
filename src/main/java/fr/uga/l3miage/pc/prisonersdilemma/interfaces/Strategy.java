package fr.uga.l3miage.pc.prisonersdilemma.interfaces;

import java.util.ArrayList;

import fr.uga.l3miage.pc.prisonersdilemma.enums.Decision;

public interface Strategy {
    public Decision execute(ArrayList<Decision> historiqueJoueur1, ArrayList<Decision> historiqueJoueur2);
}