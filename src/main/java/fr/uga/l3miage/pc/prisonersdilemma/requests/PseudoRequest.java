package fr.uga.l3miage.pc.prisonersdilemma.requests;

import fr.uga.l3miage.pc.prisonersdilemma.enums.TypeStrategy;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PseudoRequest {
    private String pseudo; 
    private Integer nbTours;
    private String strategy;
    private boolean connected;
    

    
}