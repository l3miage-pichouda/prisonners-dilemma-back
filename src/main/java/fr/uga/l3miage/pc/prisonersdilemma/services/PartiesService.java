package fr.uga.l3miage.pc.prisonersdilemma.services;

import org.springframework.stereotype.Service;
import fr.uga.l3miage.pc.prisonersdilemma.enums.Decision;
import fr.uga.l3miage.pc.prisonersdilemma.enums.TypeStrategy;
import fr.uga.l3miage.pc.prisonersdilemma.exceptions.GameNotInitializedException;
import fr.uga.l3miage.pc.prisonersdilemma.exceptions.MaximumPlayersReachedException;
import fr.uga.l3miage.pc.prisonersdilemma.modules.Joueur;
import fr.uga.l3miage.pc.prisonersdilemma.modules.Partie;

@Service
public class PartiesService {
    private Partie partie;

    public void demarrerPartie(int nbTours, String pseudo) {
        if(partie != null){
            throw new IllegalStateException("La partie est déjà initialisée.");
        }
        this.partie = new Partie(nbTours);
    }

    public boolean isGameStarted() {
        return partie != null;
    }

    public void addPlayer(String pseudo, boolean isConnected, TypeStrategy strategy) throws MaximumPlayersReachedException {
        if (partie == null) {
            throw new IllegalStateException("La partie n'a pas été initialisée. Veuillez démarrer une nouvelle partie.");
        }

        
        if (partie.getNbJoueurs() < 2) {
            partie.addJoueur(pseudo, isConnected, strategy);
        } else {
            throw new MaximumPlayersReachedException();
        }
    }

    public void abandonner(String pseudo, TypeStrategy typeStrategy) {
        Joueur joueur = partie.getJoueurs().stream()
                .filter(j -> j.getName().equals(pseudo))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Joueur non trouvé: " + pseudo));
        partie.abandonner(joueur, typeStrategy);
    }

    public boolean soumettreDecision(String pseudo, Decision decision) throws GameNotInitializedException {
        if (partie == null) {
            throw new GameNotInitializedException();
        }
        return partie.soumettreDecision(pseudo, decision);
    }

    public boolean peutJouerTour() throws GameNotInitializedException {
        if (partie == null) {
            throw new GameNotInitializedException();
        }
        return partie.peutJouerTour();
    }

    public void jouerTour() throws GameNotInitializedException {
        if (partie == null) {
            throw new GameNotInitializedException();
        }
        if (partie.peutJouerTour()) {
            partie.jouerTour();
        } else {
            throw new IllegalStateException("Les décisions des deux joueurs ne sont pas encore prêtes ou la partie est terminée.");
        }
    }
    public int getNumberOfPlayers() {
        return partie.getNbJoueurs(); 
    }
    
}
