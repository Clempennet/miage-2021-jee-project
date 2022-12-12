package fr.pantheonsorbonne.ufr27.miage.camel.dto;


import java.util.Objects;

public class Ascenseur {

    int id;
    int etage;
    boolean isGoingUp;
    boolean isInError;
    boolean isDoorOpen;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Ascenseur(int id, int etage, boolean isGoingUp, boolean isInError, boolean isDoorOpen) {
        this.id = id;
        this.etage = etage;
        this.isGoingUp = isGoingUp;
        this.isInError = isInError;
        this.isDoorOpen = isDoorOpen;
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

    @Override
    public String toString() {
        return "Ascenceur{" +
                "etage=" + etage +
                ", isGoingUp=" + isGoingUp +
                ", isInError=" + isInError +
                ", isDoorOpen=" + isDoorOpen +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ascenseur ascenseur = (Ascenseur) o;
        return etage == ascenseur.etage && isGoingUp == ascenseur.isGoingUp && isInError == ascenseur.isInError && isDoorOpen == ascenseur.isDoorOpen;
    }

    @Override
    public int hashCode() {
        return Objects.hash(etage, isGoingUp, isInError, isDoorOpen);
    }
}
