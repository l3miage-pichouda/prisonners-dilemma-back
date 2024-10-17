package fr.uga.l3miage.pc.prisonersdilemma.modules;

import java.util.ArrayList;
import java.util.List;

import fr.uga.l3miage.pc.prisonersdilemma.enums.Decision;

public class Partie {
    public static List<Decision> decisionsJoueur1 = new ArrayList<Decision>();
    public static List<Decision> decisionsJoueur2 = new ArrayList<Decision>();


    private Joueur joueur1;

    private Joueur joueur2;

    public  Partie(Joueur joueur1, Joueur joueur2) {
        decisionsJoueur1.clear();
        decisionsJoueur2.clear();
        this.joueur1 = joueur1;
        this.joueur2 = joueur2;

    }
}
