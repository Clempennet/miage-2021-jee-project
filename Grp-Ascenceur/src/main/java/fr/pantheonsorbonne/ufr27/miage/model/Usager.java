package fr.pantheonsorbonne.ufr27.miage.model;

public class Usager {
    private String nom;
    private int etageActuel;

    private boolean isInAscenseur;

    public Usager(String nom, int etageActuel, boolean isInAscenseur) {
        this.nom = nom;
        this.etageActuel = etageActuel;
        this.isInAscenseur = isInAscenseur;
    }


    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getEtageActuel() {
        return etageActuel;
    }

    public void setEtageActuel(int etageActuel) {
        this.etageActuel = etageActuel;
    }

    public boolean isInAscenseur() {
        return isInAscenseur;
    }

    public void setInAscenseur(boolean inAscenseur) {
        isInAscenseur = inAscenseur;
    }
}
