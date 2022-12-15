package fr.pantheonsorbonne.ufr27.miage.dao;

import fr.pantheonsorbonne.ufr27.miage.dto.Ascenseur;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.Collection;

@ApplicationScoped
public class AscenseurDAOImpl implements AscenseurDAO{

    @PersistenceContext(name = "sql")
    EntityManager em;

    @Override
    public Collection<Ascenseur> verifAvailabilityGroup(String group, boolean sens) {

            Collection<Ascenseur> avAsc = em.createQuery("select a from Ascenseur a where a.isInError = false and a.grpColor = :group and a.isGoingUp = :sens")
                    .setParameter("sens", sens)
                    .setParameter("group", group)
                    .getResultList();
            return avAsc;
    }

    @Override
    public Collection<Ascenseur> verifAvailabilityAtFloor(String group, boolean sens, int floor){

            return em.createQuery("select a from Ascenseur a where a.isInError = false and a.grpColor = :group and a.isGoingUp = :sens and a.currentEtage = :floor")
                    .setParameter("sens", sens)
                    .setParameter("group", group)
                    .setParameter("floor", floor)
                    .getResultList();



    }

    @Override
    @Transactional
    public String getServedFloors(String group, int idAsc){

            return  (String) em.createQuery("select a.servedFloors from Ascenseur a where a.isInError = false and a.id = :idAsc and a.grpColor = :group")
                    .setParameter("idAsc", idAsc)
                    .setParameter("group", group)
                    .getSingleResult();

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

        return (String) em.createQuery("select a.selectedFloors from Ascenseur a where a.isInError = false and a.id = :idAsc")
                .setParameter("idAsc", idAsc)
                .getSingleResult();

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

    @Override
    public Collection<Ascenseur> getStates() {
       return em.createQuery("select a from Ascenseur a").getResultList();
    }

    @Override
    public Ascenseur getHSAsc(int idAsc) {
        return (Ascenseur) em.createQuery("select a from Ascenseur a where a.id = :id and a.isInError = true")
                .setParameter("id", idAsc)
                .getSingleResult();
    }

}
