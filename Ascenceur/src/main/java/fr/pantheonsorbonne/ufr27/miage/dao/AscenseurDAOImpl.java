package fr.pantheonsorbonne.ufr27.miage.dao;

import fr.pantheonsorbonne.ufr27.miage.dto.Ascenseur;
import fr.pantheonsorbonne.ufr27.miage.exception.AscenseurHSException;
import fr.pantheonsorbonne.ufr27.miage.exception.NoAscenseurAvailableException;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;

@ApplicationScoped
public class AscenseurDAOImpl implements AscenseurDAO{

    @PersistenceContext(name = "sql")
    EntityManager em;

    @Override
    public Collection<Ascenseur> verifAvailabilityGroup(String group, boolean sens) {

            Collection<Ascenseur> ascAvailable = em.createQuery("select a from Ascenseur a where a.isInError = false and a.grpColor = :group and a.isGoingUp = :sens")
                    .setParameter("sens", sens)
                    .setParameter("group", group)
                    .getResultList();
            return ascAvailable;


    }

    @Override
    public Collection<Ascenseur> verifAvailabilityAtFloor(String group, boolean sens, int floor){

            Collection<Ascenseur> ascAvailable = em.createQuery("select a from Ascenseur a where a.isInError = false and a.grpColor = :group and a.isGoingUp = :sens and a.currentEtage = :floor")
                    .setParameter("sens", sens)
                    .setParameter("group", group)
                    .setParameter("floor", floor)
                    .getResultList();
            return ascAvailable;


    }

    @Override
    @Transactional
    public String getServedFloors(String group, int idAsc){

            String floors = (String) em.createQuery("select a.servedFloors from Ascenseur a where a.isInError = false and a.id = :idAsc and a.grpColor = :group")
                    .setParameter("idAsc", idAsc)
                    .setParameter("group", group)
                    .getSingleResult();
            return floors;

    }

    @Override
    @Transactional
    public boolean addFloor(String floor, int idAsc) {
        em.createQuery("update Ascenseur a set a.selectedFloors = CONCAT(a.selectedFloors, :floor) where a.id = :idAsc")
                .setParameter("floor", floor)
                .setParameter("idAsc", idAsc)
                .executeUpdate();
        return true;
    }

    @Override
    public String getSelectedFloors(int idAsc) {

        String floors = (String) em.createQuery("select a.selectedFloors from Ascenseur a where a.isInError = false and a.id = :idAsc")
                .setParameter("idAsc", idAsc)
                .getSingleResult();
        return floors;
    }

    @Override
    @Transactional
    public boolean deleteFloor(String updatedSelectFloors, int idAsc) {
        em.createQuery("update Ascenseur a set a.selectedFloors = :floor where a.id = :idAsc")
                .setParameter("floor", updatedSelectFloors)
                .setParameter("idAsc", idAsc)
                .executeUpdate();
        return true;
    }


}
