package fr.uga.l3miage.pc.prisonersdilemma.Strategies.Independantes;


import fr.uga.l3miage.pc.prisonersdilemma.enums.Decision;
import fr.uga.l3miage.pc.prisonersdilemma.interfaces.Strategy;
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
