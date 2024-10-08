package fr.uga.l3miage.pc.prisonersdilemma.Strategies.Dependantes;

import fr.uga.l3miage.pc.prisonersdilemma.Partie;
import fr.uga.l3miage.pc.prisonersdilemma.Strategies.Decision;
import fr.uga.l3miage.pc.prisonersdilemma.Strategies.Strategy;
import lombok.Getter;


@Getter
public class DonnantPourDeuxDonnants implements Strategy {

    private  String name ;

    public DonnantPourDeuxDonnants(){
        this.name = "DonnantPourDeuxDonnants";
    }

    @Override
    public Decision execute() {
        if (Partie.tour == 0) {
            return Decision.COOPERER;
        } else if (Partie.tour == 1) {
            return Decision.COOPERER;
        } else {
            if (Math.random() < 0.5) {
                if (Partie.decisionsJoueur2[Partie.tour - 1] == Partie.decisionsJoueur2[Partie.tour - 2]) {
                    return Partie.decisionsJoueur2[Partie.tour - 1];
                } else {
                    return Math.random() < 0.5 ? Decision.COOPERER : Decision.TRAHIR;
                }
            } else {
                return Math.random() < 0.5 ? Decision.COOPERER : Decision.TRAHIR;
            }
        }

    }


}
