package fr.pantheonsorbonne.ufr27.miage.model;

import javax.persistence.*;

@Table(name = "ascenseur")
@Entity
public class Ascenseur {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  Integer id;
  @Column()
  Integer etage;
  @Column(nullable = true)
  boolean isGoingUp;
  @Column(nullable = true)
  boolean isInError;
  @Column(nullable = true)
  boolean isDoorOpen;

  @Column(nullable = true)
  String color;



  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getEtage() {
    return etage;
  }

  public void setEtage(int etage) {
    this.etage = etage;
  }

  public boolean isGoingUp() {
    return isGoingUp;
  }

  public void setGoingUp(boolean goingUp) {
    isGoingUp = goingUp;
  }

  public boolean isInError() {
    return isInError;
  }

  public void setInError(boolean inError) {
    isInError = inError;
  }

  public boolean isDoorOpen() {
    return isDoorOpen;
  }

  public void setDoorOpen(boolean doorOpen) {
    isDoorOpen = doorOpen;
  }
}