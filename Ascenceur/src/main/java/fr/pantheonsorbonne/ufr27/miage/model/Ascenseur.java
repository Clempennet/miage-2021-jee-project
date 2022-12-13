package fr.pantheonsorbonne.ufr27.miage.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Ascenseur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idAsc", nullable = false)
    private Integer id;

    @NotNull
    @Column(name = "currentEtage", nullable = false)
    private Integer currentEtage;

    @NotNull
    @Column(name = "isGoingUp", nullable = false)
    private Boolean isGoingUp = false;

    @Column(name = "isInError")
    private Boolean isInError;

    @Size(max = 10)
    @NotNull
    @Column(name = "grpColor", nullable = false, length = 10)
    private String grpColor;

    @Size(max = 30)
    @Column(name = "selectedFloors", length = 30)
    private String selectedFloors;

    @Size(max = 30)
    @NotNull
    @Column(name = "servedFloors", nullable = false, length = 30)
    private String servedFloors;

    @NotNull
    @Column(name = "isDoorOpen", nullable = false)
    private Boolean isDoorOpen = false;

    public Boolean getIsDoorOpen() {
        return isDoorOpen;
    }

    public void setIsDoorOpen(Boolean isDoorOpen) {
        this.isDoorOpen = isDoorOpen;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCurrentEtage() {
        return currentEtage;
    }

    public void setCurrentEtage(Integer currentEtage) {
        this.currentEtage = currentEtage;
    }

    public Boolean getIsGoingUp() {
        return isGoingUp;
    }

    public void setIsGoingUp(Boolean isGoingUp) {
        this.isGoingUp = isGoingUp;
    }

    public Boolean getIsInError() {
        return isInError;
    }

    public void setIsInError(Boolean isInError) {
        this.isInError = isInError;
    }

    public String getGrpColor() {
        return grpColor;
    }

    public void setGrpColor(String grpColor) {
        this.grpColor = grpColor;
    }

    public String getSelectedFloors() {
        return selectedFloors;
    }

    public void setSelectedFloors(String selectedFloors) {
        this.selectedFloors = selectedFloors;
    }

    public String getServedFloors() {
        return servedFloors;
    }

    public void setServedFloors(String servedFloors) {
        this.servedFloors = servedFloors;
    }

}