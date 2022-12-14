package fr.pantheonsorbonne.ufr27.miage.service;


import fr.pantheonsorbonne.ufr27.miage.camel.grpAscenseurGateway;
import fr.pantheonsorbonne.ufr27.miage.model.passenger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class AppelerAscenseurImpl implements AppelerAscenseur {

    @PersistenceContext
    EntityManager em;

    @Inject
    grpAscenseurGateway grpAscenseurGateway;


    @Override
    public void getAscenseur(String color) {
        grpAscenseurGateway.getAscenseur(color);
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

    @Override
    @Transactional
    public void callAscenseur(String color, int etage) {
        grpAscenseurGateway.callAscenseur(color,etage);
    }

    @Override
    @Transactional
    public void select(int etage, int idAscenseur) {
        grpAscenseurGateway.select(etage,idAscenseur);
    }
}
