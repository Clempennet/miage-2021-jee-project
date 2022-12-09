package fr.pantheonsorbonne.ufr27.miage.service;

import fr.pantheonsorbonne.ufr27.miage.model.Usager;


import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@ApplicationScoped
public class AppelerAscenseurImpl implements AppelerAscenseur {

    @PersistenceContext
    EntityManager em;

    @Override
    @Transactional
    public void entrer(int id) {
        Usager u = em.find(Usager.class,1);
        u.setIdAscenseur(id);
        u.setEtage(-1);
    }

    @Override
    @Transactional
    public void sortir(int etage) {
        Usager u = em.find(Usager.class,1);
        u.setEtage(etage);
        u.setIdAscenseur(-1);
    }

    @Override
    @Transactional
    public void fin(int etage) {
        Usager u = em.find(Usager.class,1);
        u.setEtage(etage);
        u.setIdAscenseur(-1);
    }


}
