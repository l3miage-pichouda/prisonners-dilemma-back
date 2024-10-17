package fr.uga.l3miage.pc.prisonersdilemma.Strategies.Dependantes;

import fr.uga.l3miage.pc.prisonersdilemma.enums.Decision;
import fr.uga.l3miage.pc.prisonersdilemma.interfaces.Strategy;
import fr.uga.l3miage.pc.prisonersdilemma.modules.Partie;
import lombok.Getter;


@Getter
public class DonnantDonnantAleatoire implements Strategy {

    private  String name ;

    public DonnantDonnantAleatoire(){
        this.name = "DonnantDonnantAleatoire";
    }

    @Override
    public Decision execute() {
        if (Partie.decisionsJoueur1.size() == 0) {
            return Decision.COOPERER;
        } else {
            if (Math.random() < 0.5) {
                return Partie.decisionsJoueur1.get(Partie.decisionsJoueur1.size() - 1);
            } else {
                return Math.random() < 0.5 ? Decision.COOPERER : Decision.TRAHIR;
            }
        }
    }
}
