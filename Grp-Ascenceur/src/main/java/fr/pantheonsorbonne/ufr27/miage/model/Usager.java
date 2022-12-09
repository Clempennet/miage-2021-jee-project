package fr.pantheonsorbonne.ufr27.miage.model;

import javax.persistence.*;

@Table(name = "usager")
@Entity
public class Usager {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "num")
    private int numEtudiant;
    @Column(name = "etage")
    private int etage;

    public int getIdAscenseur() {
        return idAscenseur;
    }

    public void setIdAscenseur(int idAscenseur) {
        this.idAscenseur = idAscenseur;
    }

    @Column(name = "idAscenseur")
    private int idAscenseur;

    public int getNumEtudiant() {
        return numEtudiant;
    }

    public void setNumEtudiant(int numEtudiant) {
        this.numEtudiant = numEtudiant;
    }

    public int getEtage() {
        return etage;
    }

    public void setEtage(int etage) {
        this.etage = etage;
    }
}
