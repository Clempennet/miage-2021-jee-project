package fr.pantheonsorbonne.ufr27.miage.dao;

import fr.pantheonsorbonne.ufr27.miage.dto.Ascenseur;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@ApplicationScoped
public class AscenseurDAOImpl implements AscenseurDAO {

    @PersistenceContext(name = "mysql")
    EntityManager em;

    @Override
    @Transactional
    public void deplacerAscenseur(int id, int etage) {
        fr.pantheonsorbonne.ufr27.miage.model.Ascenseur a = em.find(fr.pantheonsorbonne.ufr27.miage.model.Ascenseur.class,id);
        a.setEtage(etage);
        em.persist(a);

    }

    @Override
    @Transactional
    public void ouvrirPorte(int id) {
        fr.pantheonsorbonne.ufr27.miage.model.Ascenseur a = em.find(fr.pantheonsorbonne.ufr27.miage.model.Ascenseur.class,id);
        a.setDoorOpen(true);
        em.persist(a);

    }

    @Override
    @Transactional
    public void fermerPorte(int id) {
        fr.pantheonsorbonne.ufr27.miage.model.Ascenseur a = em.find(fr.pantheonsorbonne.ufr27.miage.model.Ascenseur.class,id);
        a.setDoorOpen(false);
        em.persist(a);

    }

}
