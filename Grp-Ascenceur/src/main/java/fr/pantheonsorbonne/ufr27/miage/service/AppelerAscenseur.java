package fr.pantheonsorbonne.ufr27.miage.service;

import fr.pantheonsorbonne.ufr27.miage.dto.Ascenseur;
import fr.pantheonsorbonne.ufr27.miage.model.passenger;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;

public interface AppelerAscenseur {


    void porte(String color);
    void portee(int id);

    passenger entrer(int id, String name);

    void sortir(int id);
}
