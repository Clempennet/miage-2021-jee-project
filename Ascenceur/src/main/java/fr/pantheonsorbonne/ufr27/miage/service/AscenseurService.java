package fr.pantheonsorbonne.ufr27.miage.service;

import fr.pantheonsorbonne.ufr27.miage.dto.Ascenseur;

import javax.transaction.Transactional;
import java.util.List;

public interface AscenseurService {
    public  void move(int idAscenseur, int etage) throws InterruptedException;

    @Transactional
    void select(List<Integer> l) throws InterruptedException;


}
