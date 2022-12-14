package fr.pantheonsorbonne.ufr27.miage.service;


import fr.pantheonsorbonne.ufr27.miage.camel.grpAscenseurGateway;
import fr.pantheonsorbonne.ufr27.miage.model.passenger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@ApplicationScoped
public class AppelerAscenseurImpl implements AppelerAscenseur {

    @PersistenceContext
    EntityManager em;

    @Inject
    grpAscenseurGateway grpAscenseurGateway;


    @Override
    public void porte(String color) {
        grpAscenseurGateway.porte(color);
    }

    @Override
    public void portee(int id) {
        System.out.println("l'ascenseur "+id +" est ouvert");
    }

    @Override
    @Transactional
    public passenger entrer(int id, String name) {
        passenger p = new passenger();
        p.setIdAscenseur(id);
        p.setName(name);
        em.persist(p);
        return p;
    }

    @Override
    @Transactional
    public void sortir(int id) {
        em.remove(em.find(passenger.class,id));
    }
}
