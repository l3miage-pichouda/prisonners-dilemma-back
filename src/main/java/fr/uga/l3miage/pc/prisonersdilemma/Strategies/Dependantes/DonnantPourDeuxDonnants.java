package fr.uga.l3miage.pc.prisonersdilemma.Strategies.Dependantes;

import fr.uga.l3miage.pc.prisonersdilemma.enums.Decision;
import fr.uga.l3miage.pc.prisonersdilemma.interfaces.Strategy;
import fr.uga.l3miage.pc.prisonersdilemma.modules.Partie;
import lombok.Getter;


@Getter
public class DonnantPourDeuxDonnants implements Strategy {

    private  String name ;

    public DonnantPourDeuxDonnants(){
        this.name = "DonnantPourDeuxDonnants";
    }

    @Override
    public Decision execute() {
        if (Partie.decisionsJoueur1.size() == 0) {
            return Decision.COOPERER;
        } else if (Partie.decisionsJoueur1.size() == 1) {
            return Decision.COOPERER;
        } else {
            if (Math.random() < 0.5) {
                if (Partie.decisionsJoueur2.get(Partie.decisionsJoueur1.size() - 1) == Partie.decisionsJoueur1.get(Partie.decisionsJoueur1.size() - 2)) {
                    return Partie.decisionsJoueur2.get(Partie.decisionsJoueur1.size() - 1);
                } else {
                    return Math.random() < 0.5 ? Decision.COOPERER : Decision.TRAHIR;
                }
            } else {
                return Math.random() < 0.5 ? Decision.COOPERER : Decision.TRAHIR;
            }
        }

    }


}
