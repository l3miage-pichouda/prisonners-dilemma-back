package fr.uga.l3miage.pc.prisonersdilemma.Strategies.Dependantes;

import fr.uga.l3miage.pc.prisonersdilemma.enums.Decision;
import fr.uga.l3miage.pc.prisonersdilemma.interfaces.Strategy;
import fr.uga.l3miage.pc.prisonersdilemma.modules.Partie;

public class DonnantDonnant implements Strategy {

    private  String name ;

    public DonnantDonnant(){
        this.name = "DonnantDonnant";
    }

    @Override
    public Decision execute() {
        if(Partie.decisionsJoueur1.size() == 0) {
            return Decision.COOPERER;
        }
        else {
            return Partie.decisionsJoueur1.get(Partie.decisionsJoueur1.size() - 1);
        }
    }
}
