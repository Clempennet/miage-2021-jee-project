package fr.pantheonsorbonne.ufr27.miage.dto;


import java.util.List;
import java.util.Objects;

public class Ascenseur {

    int currentEtage; boolean isGoingUp; boolean isInError; boolean isDoorOpen;

    String color;
    List<Integer>  selectedFloors;

    List<Integer>  servedFloors ;

    public Ascenseur(int currentEtage, boolean isGoingUp, boolean isInError, boolean isDoorOpen, List<Integer> servedFloors, List<Integer>  selectedFloors ) {
        this.currentEtage = currentEtage;
        this.isGoingUp = isGoingUp;
        this.isInError = isInError;
        this.isDoorOpen = isDoorOpen;
        this.servedFloors = servedFloors;
        this.selectedFloors = selectedFloors;
    }

    public int getcurrentEtage() {
        return currentEtage;
    }

    public void setcurrentEtage(int currentcurrentEtage) {
        this.currentEtage = currentEtage;
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public List<Integer> getSelectedFloors() {
        return selectedFloors;
    }

    public void setSelectedFloors(List<Integer> selectedFloors) {
        selectedFloors = selectedFloors;
    }

    public List<Integer> getServedFloors() {
        return servedFloors;
    }

    public void setServedFloors(List<Integer> servedFloors) {
        servedFloors = servedFloors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ascenseur ascenseur = (Ascenseur) o;
        return currentEtage == ascenseur.currentEtage && isGoingUp == ascenseur.isGoingUp && isInError == ascenseur.isInError && isDoorOpen == ascenseur.isDoorOpen && Objects.equals(selectedFloors, ascenseur.selectedFloors) && servedFloors.equals(ascenseur.servedFloors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(currentEtage, isGoingUp, isInError, isDoorOpen, selectedFloors, servedFloors);
    }

    @Override
    public String toString() {
        return "Ascenseur{" +
                "currentEtage=" + currentEtage +
                ", isGoingUp=" + isGoingUp +
                ", isInError=" + isInError +
                ", isDoorOpen=" + isDoorOpen +
                ", selectedFloors=" + selectedFloors +
                ", servedFloors=" + servedFloors +
                '}';
    }


}
