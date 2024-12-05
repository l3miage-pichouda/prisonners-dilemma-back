package fr.uga.l3miage.pc.prisonersdilemma.enums;

import com.fasterxml.jackson.databind.ser.std.StdKeySerializers.Default;

public enum TypeStrategy {
    DEFAULT,
    RANDOM,
    COOPERATE,
    BETRAY,
    DONNANT_DONNANT,
    DONNANT_DONNANT_ALEATOIRE,
    DONNANT_POUR_DEUX_DONNANTS_ALEATOIRE,
    DONNANT_POUR_DEUX_DONNANTS,
    SONDEUR_NAIF,
    SONDEUR_REPENTANT,
    PACIFICATEUR_NAIF,
    VRAI_PACIFICATEUR,
    ALEATOIRE,
    TOUJOURS_TRAHIR,
    TOUJOURS_COOPERER,
    RANCUNIER,
    DONNANT_DONNANT_SOUPCONNEUX,
    RANCUNIER_DOUX
}
