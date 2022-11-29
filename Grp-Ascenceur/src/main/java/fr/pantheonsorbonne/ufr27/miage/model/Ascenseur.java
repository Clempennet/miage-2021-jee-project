package fr.pantheonsorbonne.ufr27.miage.model;


public class Ascenseur extends GrpAscenseur {
    
  private int id;
  private String direction;//monté descente
  private int etage;
  private int etageSelectionne;
  private String etat; //hs ou op
  private String porte; //ouverte ou fermé

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getDirection() {
    return direction;
  }

  public void setDirection(String direction) {
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

  public String getEtat() {
    return etat;
  }

  public void setEtat(String etat) {
    this.etat = etat;
  }

  public String getPorte() {
    return porte;
  }

  public void setPorte(String porte) {
    this.porte = porte;
  }
}
