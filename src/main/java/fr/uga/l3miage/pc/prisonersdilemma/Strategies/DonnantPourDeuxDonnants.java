package fr.uga.l3miage.pc.prisonersdilemma.strategies;
import java.util.ArrayList;
import fr.uga.l3miage.pc.prisonersdilemma.enums.Decision;
import fr.uga.l3miage.pc.prisonersdilemma.interfaces.Strategy;
import lombok.Getter;


@Getter
public class DonnantPourDeuxDonnants implements Strategy {

    @Override
    public Decision execute(ArrayList<Decision> historiqueJoueur1, ArrayList<Decision> historiqueJoueur2) {
        if (historiqueJoueur2.isEmpty()) {
            return Decision.COOPERER;
        }
        if (historiqueJoueur2.size() < 2) {
            return Decision.COOPERER;
        }
        if (historiqueJoueur2.get(historiqueJoueur2.size() - 1) == historiqueJoueur2.get(historiqueJoueur2.size() - 2)) {
            return historiqueJoueur2.get(historiqueJoueur2.size() - 1);
        }
        return Decision.COOPERER;

    }


}
