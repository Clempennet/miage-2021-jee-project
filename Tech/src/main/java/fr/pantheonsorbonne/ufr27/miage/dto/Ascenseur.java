package fr.pantheonsorbonne.ufr27.miage.dto;


import java.util.Objects;

public class Ascenseur {


    int id;
    int currentEtage; boolean isGoingUp; boolean isInError; boolean isDoorOpen;

    String color;
    String  selectedFloors;

    String  servedFloors ;

    public Ascenseur(int id, int currentEtage, boolean isGoingUp, boolean isInError, boolean isDoorOpen, String servedFloors, String  selectedFloors, String color ) {
        this.currentEtage = currentEtage;
        this.isGoingUp = isGoingUp;
        this.isInError = isInError;
        this.isDoorOpen = isDoorOpen;
        this.servedFloors = servedFloors;
        this.selectedFloors = selectedFloors;
        this.color = color;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getSelectedFloors() {
        return selectedFloors;
    }

    public void setSelectedFloors(String selectedFloors) {
        selectedFloors = selectedFloors;
    }

    public String getServedFloors() {
        return servedFloors;
    }

    public void setServedFloors(String servedFloors) {
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
