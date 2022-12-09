package fr.pantheonsorbonne.ufr27.miage.service;

import fr.pantheonsorbonne.ufr27.miage.camel.AscenseurGateway;
import fr.pantheonsorbonne.ufr27.miage.model.Ascenseur;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class AscenseurServiceImpl implements AscenseurService {

    @PersistenceContext
    EntityManager em;

    @Inject
    AscenseurGateway ascenseurGateway;

    @Override
    @Transactional
    public void move(int idAscenseur, int etage) {
        Ascenseur ascenseur = em.find(Ascenseur.class, idAscenseur);
        ascenseur.setEtage(etage);
        ascenseur.setDoorOpen(true);
        ascenseurGateway.AscenseurIsOpen(idAscenseur);

    }

    @Override
    @Transactional
    public void select(List<Integer> l) {
        int etage = l.get(0);
        int idAscenseur = l.get(1);
        Ascenseur a = em.find(Ascenseur.class, idAscenseur);
        a.setDoorOpen(false);
        a.setEtage(etage);
        a.setDoorOpen(true);
        ascenseurGateway.sortir(etage);
    }







}
