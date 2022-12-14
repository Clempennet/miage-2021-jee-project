package fr.pantheonsorbonne.ufr27.miage.service;

import fr.pantheonsorbonne.ufr27.miage.dto.Ascenseur;

import javax.transaction.Transactional;
import java.util.List;

public interface AscenseurService {
    public  void move(int idAscenseur, int etage);

    @Transactional
    void select(List<Integer> l);
    @Transactional
    void porte(String color);

}
