package fr.uga.l3miage.pc.prisonersdilemma.Strategies.Independantes;


import fr.uga.l3miage.pc.prisonersdilemma.Strategies.Decision;
import fr.uga.l3miage.pc.prisonersdilemma.Strategies.Strategy;
import lombok.Getter;

@Getter
public class ToujoursCooperer implements Strategy {

    private  String name ;

    public ToujoursCooperer() {
        this.name = "ToujoursCooperer";
    }

    public Decision execute() {
        return Decision.COOPERER;
    }
}
