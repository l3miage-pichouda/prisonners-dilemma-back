package fr.uga.l3miage.pc.prisonersdilemma.modules;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

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
    private final Map<String, ArrayList<Decision>> historiqueDecisionsMap = new HashMap<>();
    private StrategyFactory strategyFactory;
    private int nbTours;
    private int tourActuel = 1;
    private boolean decisionsProcessed = false;



    private final List<Joueur> joueurs = new ArrayList<>();

    public Partie(int nbTours) {
        this.strategyFactory = new StrategyFactory();
        this.nbTours = nbTours;
    }

    public void addJoueur(String pseudo, boolean isConnected, TypeStrategy strategy) throws IllegalStateException {
        Joueur joueur = new Joueur();
        if (isConnected) {
            if (pseudo == null || pseudo.isEmpty()) {
                throw new IllegalStateException("Le nom du joueur ne peut pas être vide.");
            } else if (joueurs.stream().anyMatch(j -> j.getName().equals(pseudo))) {
                throw new IllegalStateException("Le nom du joueur est déjà utilisé.");
            }
            joueur.setName(pseudo);
        } else {
            joueur.setName("Blip-Boup-Bap");
            joueur.setConnected(false);
            joueur.setStrategy(strategyFactory.create(strategy));
        }
        joueurs.add(joueur);
        historiqueDecisionsMap.put(joueur.getName(), new ArrayList<>());
    }

    public int getNbJoueurs() {
        return joueurs.size();
    }

    public void abandonner(Joueur joueur, TypeStrategy typeStrategy) {
        joueur.setConnected(false);
        joueur.setStrategy(strategyFactory.create(typeStrategy));
    }

    public boolean soumettreDecision(String pseudo, Decision decision) {
        Joueur joueur1 = joueurs.get(0);
        Joueur joueur2 = joueurs.size() > 1 ? joueurs.get(1) : null;
    
        int historiqueDecisionsMapSize1 = historiqueDecisionsMap.get(joueur1.getName()).size();

        int historiqueDecisionsMapSize2 = joueur2 != null ? historiqueDecisionsMap.get(joueur2.getName()).size() : 0;
        
        if (joueur1.getName().equals(pseudo) && historiqueDecisionsMapSize1 < tourActuel) {
            joueur1.setDecision(decision);
            historiqueDecisionsMap.get(joueur1.getName()).add(decision);
            historiqueDecisionsMapSize1++;
            System.out.println("Décision de " + joueur1.getName() + ": " + decision);
        } 
        if (joueur2 != null && joueur2.getName().equals(pseudo) && historiqueDecisionsMapSize2 < tourActuel) {
            joueur2.setDecision(decision);
            historiqueDecisionsMap.get(joueur2.getName()).add(decision);
            historiqueDecisionsMapSize2++;
            System.out.println("Décision de " + joueur2.getName() + ": " + decision);
        }
        // if (joueur2 != null && !joueur2.isConnected() && joueur2.getDecision() == null) {
        //     joueur2.setDecision(joueur2.getStrategy().execute(null, null));
        //     System.out.println("Décision automatique pour joueur déconnecté: " + joueur2.getDecision());
        // }

        if (historiqueDecisionsMapSize1 == tourActuel && historiqueDecisionsMapSize2 == tourActuel) {
            processRound(joueur1, joueur2);
            tourActuel++;
            
        }
        return true; 
    }
    


    private void processRound(Joueur joueur1, Joueur joueur2) {
        Decision decision1 = joueur1.getDecision();
        Decision decision2 = joueur2.getDecision();
    
        if (decision1 == Decision.COOPERER && decision2 == Decision.COOPERER) {
            joueur1.ajouterScore(3);
            joueur2.ajouterScore(3);
        } else if (decision1 == Decision.COOPERER && decision2 == Decision.TRAHIR) {
            joueur1.ajouterScore(0);
            joueur2.ajouterScore(5);
        } else if (decision1 == Decision.TRAHIR && decision2 == Decision.COOPERER) {
            joueur1.ajouterScore(5);
            joueur2.ajouterScore(0);
        } else if (decision1 == Decision.TRAHIR && decision2 == Decision.TRAHIR) {
            joueur1.ajouterScore(1);
            joueur2.ajouterScore(1);
        }
    
        System.out.println("Tour terminé. Scores mis à jour:");
        System.out.println(joueur1.getName() + " score: " + joueur1.getScore());
        System.out.println(joueur2.getName() + " score: " + joueur2.getScore());
      


        decisionsProcessed = true;

    // Delay reset to allow front-end to fetch decisions
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                resetDecisions();
                decisionsProcessed = false;
            }
        }, 5000);
    }
    


    public boolean peutJouerTour() {
        return (joueurs.get(0).getDecision() != null && joueurs.get(1).getDecision() != null) && tourActuel <= nbTours;
        
    }



    public boolean getDecisionOfOtherPlayer(String pseudo) {
        System.out.println("Getting decision of other player for pseudo: " + pseudo);
        for (Joueur j : joueurs) {
            System.out.println("Player in list: " + j.getName() + ", Decision: " + j.getDecision());
        }
    
        Joueur requestingPlayer = joueurs.stream()
                .filter(j -> j.getName().equals(pseudo))
                .findFirst()
                .orElse(null);
    
        if (requestingPlayer == null) {
            System.out.println("Requesting player not found.");
            return false;
        }
    
        Joueur otherPlayer = joueurs.stream()
                .filter(j -> !j.getName().equals(pseudo))
                .findFirst()
                .orElse(null);
    
        if (otherPlayer != null) {
        System.out.println("Other player found: " + otherPlayer.getName());
        List<Decision> historique = historiqueDecisionsMap.get(otherPlayer.getName());
        if (historique != null && !historique.isEmpty()) {
            System.out.println("Other player's historical decision: " + historique.get(historique.size() - 1));
            return true;
        } else {
            System.out.println("Other player's decision is null.");
        }
        } else {
            System.out.println("No other player found.");
        }
        return false;
    }
    

    public List<Decision> getHistorique(String pseudo) {
        return historiqueDecisionsMap.getOrDefault(pseudo, new ArrayList<>());
    }

    public void resetDecisions() {

        System.out.println("Resetting decisions for all players.");

        for (Joueur j : joueurs) {
            j.setDecision(null);
        }
    }

}
