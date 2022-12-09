package fr.pantheonsorbonne.ufr27.miage.dao;

import fr.pantheonsorbonne.ufr27.miage.dto.Ascenseur;

public interface AscenseurDAO {

    public void deplacerAscenseur(int id, int etage);
    public void fermerPorte(int id);
    public void ouvrirPorte(int id);
    }
