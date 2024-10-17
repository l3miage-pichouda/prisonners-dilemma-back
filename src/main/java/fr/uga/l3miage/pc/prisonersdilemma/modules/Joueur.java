package fr.uga.l3miage.pc.prisonersdilemma.modules;

import org.springframework.boot.autoconfigure.web.WebProperties.Resources.Chain.Strategy;


public class Joueur {
    
    Strategy strategy;

    String name;

    Integer score;

    public Joueur(Strategy strategy, String name, Integer score) {
        this.strategy = strategy;
        this.name = name;
        this.score = score;
    }

    public void addStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public void addScore(Integer score) {
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public Integer getScore() {
        return score;
    }


}
