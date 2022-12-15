package fr.pantheonsorbonne.ufr27.miage.service;

import java.util.Collection;
import java.util.List;
import fr.pantheonsorbonne.ufr27.miage.model.Ascenseur;
import fr.pantheonsorbonne.ufr27.miage.exception.AscenseurHSException;
import fr.pantheonsorbonne.ufr27.miage.exception.NoAscenseurAvailableException;
import fr.pantheonsorbonne.ufr27.miage.exception.NotServedFloorException;

public interface FloorService {

    void goToFloor(String floor, String group, int idAsc) throws AscenseurHSException, NotServedFloorException;

    Collection<Ascenseur> getAvailableAtFloor(String color, String sens, int floor) throws NoAscenseurAvailableException;

    List<Integer> getServedFloors(String group, int idAsc) throws NoAscenseurAvailableException;

    boolean verifyAvailabilityGroup(String color, String sens) throws NoAscenseurAvailableException;

    void deleteFloor(String floor, int idAsc) throws NotServedFloorException;

}
