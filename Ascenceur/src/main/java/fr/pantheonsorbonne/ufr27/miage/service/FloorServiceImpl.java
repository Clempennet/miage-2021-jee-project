package fr.pantheonsorbonne.ufr27.miage.service;

import fr.pantheonsorbonne.ufr27.miage.resources.dto.Ascenseur;

import java.util.List;

public class FloorServiceImpl implements FloorService{

    @Override
    public List<Integer> goToFloor(Ascenseur ascenseur) {
        return ascenseur.getSelectedFloors();
    }
}
