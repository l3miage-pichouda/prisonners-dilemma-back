package fr.uga.l3miage.pc.prisonersdilemma.strategies;
import fr.uga.l3miage.pc.prisonersdilemma.enums.TypeStrategy;
import fr.uga.l3miage.pc.prisonersdilemma.interfaces.Strategy;

public class StrategyFactory {

    public Strategy create(TypeStrategy typeStrategy) {
        switch (typeStrategy) {
            case ALEATOIRE:
                return new Aleatoire();
            case TOUJOURS_COOPERER:
                return new ToujoursCooperer();
            case TOUJOURS_TRAHIR:
                return new ToujoursTrahir();
            default:
            return null;
        }
    }
}
