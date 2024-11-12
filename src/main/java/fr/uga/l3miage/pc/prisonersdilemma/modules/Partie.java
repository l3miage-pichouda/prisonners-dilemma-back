package fr.uga.l3miage.pc.prisonersdilemma.modules;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fr.uga.l3miage.pc.prisonersdilemma.enums.Decision;
import fr.uga.l3miage.pc.prisonersdilemma.enums.TypeStrategy;
import fr.uga.l3miage.pc.prisonersdilemma.strategies.StrategyFactory;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Partie {
    private final Map<String, List<Decision>> historiqueDecisionsMap = new HashMap<>();
    private Decision decisionJoueur1;
    private Decision decisionJoueur2;
    private StrategyFactory strategyFactory;
    private int nbTours;
    private int tourActuel = 0;

    private final List<Joueur> joueurs = new ArrayList<>();

    public Partie(int nbTours) {
        this.strategyFactory = new StrategyFactory();
        this.nbTours = nbTours;
    }

    public void addJoueur(Joueur joueur){
        joueurs.add(joueur);
        historiqueDecisionsMap.put(joueur.getName(), new ArrayList<>());
    }

    public int getNbJoueurs(){
        return joueurs.size();
        }


    public void abandonner(Joueur joueur, TypeStrategy typeStrategy){
        joueur.setConnected(false);
        joueur.setStrategy(strategyFactory.create(typeStrategy));
    }
    public boolean soumettreDecision(String pseudo, Decision decision) {
        if (joueurs.get(0).getName().equals(pseudo)) {
            if (decisionJoueur1 == null) {
                decisionJoueur1 = decision;
                return true;
            }
        } else if (joueurs.size() > 1 && joueurs.get(1).getName().equals(pseudo) && decisionJoueur2 == null) {
            decisionJoueur2 = decision;
            return true;
        }
        return false;
    }
    public boolean peutJouerTour() {
        return (decisionJoueur1 != null && decisionJoueur2 != null) && tourActuel <= nbTours;
    }

    public void jouerTour() {
        if (!peutJouerTour()) {
            throw new IllegalStateException("Les décisions des deux joueurs ne sont pas encore prêtes.");
        }

        // Enregistre les décisions du tour actuel dans l'historique
        historiqueDecisionsMap.get(joueurs.get(0).getName()).add(decisionJoueur1);
        historiqueDecisionsMap.get(joueurs.get(1).getName()).add(decisionJoueur2);

        // Logique pour mettre à jour les scores des joueurs en fonction des décisions
        mettreAJourScores();

        // Prépare pour le tour suivant
        decisionJoueur1 = null;
        decisionJoueur2 = null;
        tourActuel++;
    }

    private void mettreAJourScores() {
        // Logique pour appliquer les décisions et ajuster les scores des joueurs
        // Exemple : ajouter un score basé sur la combinaison des décisions (coopération/trahison)
        if (decisionJoueur1 == Decision.COOPERER && decisionJoueur2 == Decision.COOPERER) {
            joueurs.get(0).ajouterScore(3);
            joueurs.get(1).ajouterScore(3);
        } else if (decisionJoueur1 == Decision.TRAHIR && decisionJoueur2 == Decision.TRAHIR) {
            joueurs.get(0).ajouterScore(1);
            joueurs.get(1).ajouterScore(1);
        } else if (decisionJoueur1 == Decision.COOPERER && decisionJoueur2 == Decision.TRAHIR) {
            joueurs.get(0).ajouterScore(0);
            joueurs.get(1).ajouterScore(5);
        } else if (decisionJoueur1 == Decision.TRAHIR && decisionJoueur2 == Decision.COOPERER) {
            joueurs.get(0).ajouterScore(5);
            joueurs.get(1).ajouterScore(0);
        }
    }

}
