package fr.pantheonsorbonne.ufr27.miage.service;

import java.util.Collection;
import java.util.List;
import fr.pantheonsorbonne.ufr27.miage.dto.Ascenseur;
import fr.pantheonsorbonne.ufr27.miage.exception.NoAscenseurAvailableException;

public interface FloorService {

    List<Integer> goToFloor(Ascenseur ascenseur);
    String getState(int idAsc);

    Collection<Ascenseur> getAvailableAtFloor(int floor, int idAsc);

    List<Integer> getServedFloors(int idAsc);

    Collection<Ascenseur> verifyAvailabilityGroup(String color) throws NoAscenseurAvailableException;


}
