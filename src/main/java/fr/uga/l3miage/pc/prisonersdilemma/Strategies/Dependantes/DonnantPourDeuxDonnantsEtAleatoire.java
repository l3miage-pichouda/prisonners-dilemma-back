package fr.uga.l3miage.pc.prisonersdilemma.Strategies.Dependantes;

import fr.uga.l3miage.pc.prisonersdilemma.enums.Decision;
import fr.uga.l3miage.pc.prisonersdilemma.interfaces.Strategy;
import fr.uga.l3miage.pc.prisonersdilemma.modules.Partie;

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
