package fr.uga.l3miage.pc.prisonersdilemma.Strategies.Dependantes;

import fr.uga.l3miage.pc.prisonersdilemma.Partie;
import fr.uga.l3miage.pc.prisonersdilemma.Strategies.Decision;
import fr.uga.l3miage.pc.prisonersdilemma.Strategies.Strategy;

public class DonnantDonnant implements Strategy {

    private  String name ;

    public DonnantDonnant(){
        this.name = "DonnantDonnant";
    }

    @Override
    public Decision execute() {
        if(Partie.tour == 0) {
            return Decision.COOPERER;
        }
        else {
            return Partie.decisionsJoueur1[Partie.tour - 1];
        }
    }
}
