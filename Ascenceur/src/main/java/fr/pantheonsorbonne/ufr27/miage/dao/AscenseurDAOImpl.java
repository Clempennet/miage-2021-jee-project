package fr.pantheonsorbonne.ufr27.miage.dao;

import fr.pantheonsorbonne.ufr27.miage.dto.Ascenseur;
import fr.pantheonsorbonne.ufr27.miage.exception.NoAscenseurAvailableException;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.util.Collection;
import java.util.List;

@ApplicationScoped
public class AscenseurDAOImpl implements AscenseurDAO{

    @PersistenceContext(name = "sql")
    EntityManager em;

    @Override
    public Collection<Ascenseur> verifAvailabilityGroup(String color) throws NoAscenseurAvailableException {
        try{
            Collection<Ascenseur> ascInError = em.createQuery("select a from Ascenseur a where a.isInError = false").getResultList();
            return ascInError;
        }
        catch (NoResultException e){
            throw new NoAscenseurAvailableException();
        }

    }


}
