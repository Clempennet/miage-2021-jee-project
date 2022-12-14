package fr.pantheonsorbonne.ufr27.miage.dao;

import fr.pantheonsorbonne.ufr27.miage.dto.Ascenseur;
import fr.pantheonsorbonne.ufr27.miage.exception.AscenseurHSException;
import fr.pantheonsorbonne.ufr27.miage.exception.NoAscenseurAvailableException;

import java.util.Collection;

public interface AscenseurDAO {

    public Collection<Ascenseur> verifAvailabilityGroup(String group, boolean sens) ;

    public Collection<Ascenseur> verifAvailabilityAtFloor(String group, boolean sens, int floor);

    public String getServedFloors(String group, int idAsc);

    public boolean addFloor(String floor, int idAsc);

    public String getSelectedFloors(int idAsc);

    public boolean deleteFloor(String updatedSelectFloors, int idAsc);
}
