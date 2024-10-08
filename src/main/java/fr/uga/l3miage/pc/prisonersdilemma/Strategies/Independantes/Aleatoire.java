package fr.uga.l3miage.pc.prisonersdilemma.Strategies.Independantes;

import fr.uga.l3miage.pc.prisonersdilemma.Strategies.Decision;
import fr.uga.l3miage.pc.prisonersdilemma.Strategies.Strategy;
import lombok.Getter;

@Getter
public class Aleatoire implements Strategy {

    private  String name ;

    public Aleatoire() {
        this.name = "Aleatoire";
    }

    public Decision execute() {
        if (Math.random() < 0.5) {
            return Decision.COOPERER;
        } else {
            return Decision.TRAHIR;
        }
    }
}
