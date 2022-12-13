package fr.pantheonsorbonne.ufr27.miage.service;

import fr.pantheonsorbonne.ufr27.miage.dao.AscenseurDAO;
import fr.pantheonsorbonne.ufr27.miage.dto.Ascenseur;
import fr.pantheonsorbonne.ufr27.miage.exception.NoAscenseurAvailableException;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.Collection;
import java.util.List;

@ApplicationScoped
public class FloorServiceImpl implements FloorService{

    @Inject
    AscenseurDAO ascDAO;

    @Override
    public List<Integer> goToFloor(Ascenseur ascenseur) {
        //add floor to selectedFloor
        return ascenseur.getSelectedFloors();
    }

    @Override
    public String getState(int idAsc) {
        // isDoorOpen ou isInError
        return null;
    }

    @Override
    public Collection<Ascenseur> getAvailableAtFloor(int floor, int idAsc) {
        // quel ascenseur à mon étage ou proche
        return null;
    }

    @Override
    public List<Integer> getServedFloors(int idAsc) {
        //afin de choisir l'étage auquel je me rend j'ai besoin de la liste des étages desservis
        return null;
    }

    @Override
    public Collection<Ascenseur> verifyAvailabilityGroup(String color) throws NoAscenseurAvailableException {
        return ascDAO.verifAvailabilityGroup(color);
    }


}
