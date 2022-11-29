package fr.pantheonsorbonne.ufr27.miage.dto;


import fr.pantheonsorbonne.ufr27.miage.model.Ascenseur;

import java.util.Objects;
import java.util.List;

public class GrpAscenseur {

    String color;

    List<Ascenseur> ascenseur;


    public GrpAscenseur(String color, List<Ascenseur> ascenseur) {
        this.color = color;
        this.ascenseur = ascenseur;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public List<Ascenseur> getAscenseur() {
        return ascenseur;
    }

    public void setAscenseur(List<Ascenseur> ascenseur) {
        this.ascenseur = ascenseur;
    }
}
