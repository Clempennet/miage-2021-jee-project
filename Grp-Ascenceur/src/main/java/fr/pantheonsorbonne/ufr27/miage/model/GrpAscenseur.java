package fr.pantheonsorbonne.ufr27.miage.model;

import java.util.ArrayList;
import java.util.List;

public class GrpAscenseur {
    
  private String couleur;


  private int etageDesservi;
  private int poidsMax;

  public List<Ascenseur> getAscenseur() {
    return ascenseur;
  }

  public void setAscenseur(ArrayList<Ascenseur> ascenseur) {
    this.ascenseur = ascenseur;
  }

  private List<Ascenseur> ascenseur;

  public String getCouleur() {
    return couleur;
  }

  public void setCouleur(String couleur) {
    this.couleur = couleur;
  }

  public int getEtageDesservi() {
    return etageDesservi;
  }

  public void setEtageDesservi(int etageDesservi) {
    this.etageDesservi = etageDesservi;
  }

  public int getPoidsMax() {
    return poidsMax;
  }

  public void setPoidsMax(int poidsMax) {
    this.poidsMax = poidsMax;
  }
}
