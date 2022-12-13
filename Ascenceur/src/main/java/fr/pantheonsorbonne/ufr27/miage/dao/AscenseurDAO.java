package fr.pantheonsorbonne.ufr27.miage.dao;

import fr.pantheonsorbonne.ufr27.miage.dto.Ascenseur;
import fr.pantheonsorbonne.ufr27.miage.exception.NoAscenseurAvailableException;

import java.util.Collection;

public interface AscenseurDAO {

    public Collection<Ascenseur> verifAvailabilityGroup(String color) throws NoAscenseurAvailableException;
}
