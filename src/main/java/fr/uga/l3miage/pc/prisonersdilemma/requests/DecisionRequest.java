package fr.uga.l3miage.pc.prisonersdilemma.requests;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DecisionRequest {

    private String pseudo;
    private String decision;
}
