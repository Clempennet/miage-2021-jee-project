package fr.pantheonsorbonne.ufr27.miage.dto;


import java.util.Objects;

public class Ascenceur {
    int etage; boolean isGoingUp; boolean isInError; boolean isDoorOpen;
    public Ascenceur(int etage, boolean isGoingUp, boolean isInError, boolean isDoorOpen) {
        this.etage = etage;
        this.isGoingUp = isGoingUp;
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
        Ascenceur ascenceur = (Ascenceur) o;
        return etage == ascenceur.etage && isGoingUp == ascenceur.isGoingUp && isInError == ascenceur.isInError && isDoorOpen == ascenceur.isDoorOpen;
    }

    @Override
    public int hashCode() {
        return Objects.hash(etage, isGoingUp, isInError, isDoorOpen);
    }
}
