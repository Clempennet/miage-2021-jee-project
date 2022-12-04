package fr.pantheonsorbonne.ufr27.miage.service;

import fr.pantheonsorbonne.ufr27.miage.dto.Ascenseur;

import java.util.Collection;

public interface AppelerAscenseur {
    public void alert();
    public void entrer();

    public Collection<Ascenseur> getAscenseur();
}
