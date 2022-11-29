package fr.pantheonsorbonne.ufr27.miage.model;

import javax.persistence.Entity;
import javax.persistence.*;

@Entity
public class Ascenseur {

  @Id
  private int id;
  private boolean direction;//monté descente
  @Column(name = "etage", nullable = false)
  private int etage;
  private int etageSelectionne;
  private boolean etat; //hs ou op
  private boolean porte; //ouverte ou fermé

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public boolean getDirection() {
    return direction;
  }

  public void setDirection(boolean direction) {
    this.direction = direction;
  }

  public int getEtage() {
    return etage;
  }

  public void setEtage(int etage) {
    this.etage = etage;
  }

  public int getEtageSelectionne() {
    return etageSelectionne;
  }

  public void setEtageSelectionne(int etageSelectionne) {
    this.etageSelectionne = etageSelectionne;
  }

  public boolean getEtat() {
    return etat;
  }

  public void setEtat(boolean etat) {
    this.etat = etat;
  }

  public boolean getPorte() {
    return porte;
  }

  public void setPorte(boolean porte) {
    this.porte = porte;
  }
}
