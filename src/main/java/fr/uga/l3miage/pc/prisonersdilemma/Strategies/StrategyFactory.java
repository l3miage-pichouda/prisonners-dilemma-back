package fr.uga.l3miage.pc.prisonersdilemma.strategies;
import fr.uga.l3miage.pc.prisonersdilemma.enums.TypeStrategy;
import fr.uga.l3miage.pc.prisonersdilemma.interfaces.Strategy;

public class StrategyFactory {

    public Strategy create(TypeStrategy typeStrategy) {
        switch (typeStrategy) {
            case RANDOM:
                return new Aleatoire();
            case COOPERATE:
                return new ToujoursCooperer();
            case BETRAY:
                return new ToujoursTrahir();
            default:
            return null;
        }
    }
}
