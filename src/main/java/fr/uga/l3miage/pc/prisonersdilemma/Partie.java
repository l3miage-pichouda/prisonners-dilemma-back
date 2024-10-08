package fr.uga.l3miage.pc.prisonersdilemma;

import fr.uga.l3miage.pc.prisonersdilemma.Strategies.Decision;

public class Partie {
    public static Decision[] decisionsJoueur1 = new Decision[100];
    public static Decision[] decisionsJoueur2 = new Decision[100];

    public static int tour;

    public  Partie() {
        tour = 0;
    }
}
