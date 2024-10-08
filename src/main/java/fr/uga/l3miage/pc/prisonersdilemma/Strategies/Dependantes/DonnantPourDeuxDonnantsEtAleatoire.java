package fr.uga.l3miage.pc.prisonersdilemma.Strategies.Dependantes;

import fr.uga.l3miage.pc.prisonersdilemma.Partie;
import fr.uga.l3miage.pc.prisonersdilemma.Strategies.Decision;
import fr.uga.l3miage.pc.prisonersdilemma.Strategies.Strategy;

public class DonnantPourDeuxDonnantsEtAleatoire implements Strategy {

    private  String name ;

    public DonnantPourDeuxDonnantsEtAleatoire(){
        this.name = "DonnantPourDeuxDonnantsEtAleatoire";
    }


    @Override
    public Decision execute() {
        return Decision.COOPERER;
    }

}
