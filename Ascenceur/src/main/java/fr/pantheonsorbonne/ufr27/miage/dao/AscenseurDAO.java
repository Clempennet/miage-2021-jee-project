package fr.pantheonsorbonne.ufr27.miage.dao;

import fr.pantheonsorbonne.ufr27.miage.dto.Ascenseur;
import fr.pantheonsorbonne.ufr27.miage.exception.CustomerNotFoundException;
import fr.pantheonsorbonne.ufr27.miage.model.Customer;

public interface AscenseurDAO {
    Ascenseur createNewAscenseur(int id, int etage, boolean isGoingUp, boolean isInError, boolean isDoorOpen);

    }
