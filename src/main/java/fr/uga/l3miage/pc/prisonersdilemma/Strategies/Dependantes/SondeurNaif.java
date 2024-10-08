package fr.uga.l3miage.pc.prisonersdilemma.Strategies.Dependantes;

import fr.uga.l3miage.pc.prisonersdilemma.Strategies.Decision;
import fr.uga.l3miage.pc.prisonersdilemma.Strategies.Strategy;

public class SondeurNaif implements Strategy {

    private String name ;

    public SondeurNaif(){
        this.name = "SondeurNaif";
    }

    @Override
    public Decision execute() {

        return Decision.values()[(int)(Math.random() * 3)];
    }


}
