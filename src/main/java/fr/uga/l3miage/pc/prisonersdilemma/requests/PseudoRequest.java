package fr.uga.l3miage.pc.prisonersdilemma.requests;

public class PseudoRequest {
    private String pseudo; 
    private Integer nbTours;
    
    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public Integer getNbTours() {
        return nbTours;
    }

    public void setNbTours(Integer nbTours) {
        this.nbTours = nbTours;
    }

    
}