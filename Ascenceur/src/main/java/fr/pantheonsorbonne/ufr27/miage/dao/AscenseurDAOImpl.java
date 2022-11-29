package fr.pantheonsorbonne.ufr27.miage.dao;

import fr.pantheonsorbonne.ufr27.miage.dto.Ascenseur;
import fr.pantheonsorbonne.ufr27.miage.exception.CustomerNotFoundException;
import fr.pantheonsorbonne.ufr27.miage.model.Customer;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@ApplicationScoped
public class AscenseurDAOImpl implements AscenseurDAO {

    @PersistenceContext(name = "mysql")
    EntityManager em;

    @Override
    @Transactional
    public Ascenseur createNewAscenseur(int id, int etage, boolean isGoingUp, boolean isInError, boolean isDoorOpen) {
        Ascenseur a = new Ascenseur(id, etage, isGoingUp, isInError, isDoorOpen);
        em.persist(a);
        return a;
    }
}
