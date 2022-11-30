package fr.pantheonsorbonne.ufr27.miage.service;

import java.util.List;
import fr.pantheonsorbonne.ufr27.miage.resources.dto.Ascenseur;

public interface FloorService {

    List<Integer> goToFloor(Ascenseur ascenseur);
}
