package fr.pantheonsorbonne.ufr27.miage.service;

import fr.pantheonsorbonne.ufr27.miage.dto.Ascenseur;

import javax.transaction.Transactional;
import java.util.Collection;

public interface AppelerAscenseur {


    @Transactional
    void sortir(int etage);

    @Transactional
    void entrer(int etage);

    @Transactional
    void fin(int etage);
}
