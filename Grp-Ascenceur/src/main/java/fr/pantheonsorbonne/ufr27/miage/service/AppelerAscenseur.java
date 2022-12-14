package fr.pantheonsorbonne.ufr27.miage.service;

import fr.pantheonsorbonne.ufr27.miage.dto.Ascenseur;
import fr.pantheonsorbonne.ufr27.miage.model.passenger;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;

public interface AppelerAscenseur {


    void getAscenseur(String color);


    passenger entrer(int id, String name);

    void sortir(int id);

    void callAscenseur(String color, int etage);

    void select(int etage, int idAscenseur);
}
