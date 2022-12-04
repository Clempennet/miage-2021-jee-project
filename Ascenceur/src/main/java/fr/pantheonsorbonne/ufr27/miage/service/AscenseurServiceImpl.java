package fr.pantheonsorbonne.ufr27.miage.service;

import fr.pantheonsorbonne.ufr27.miage.camel.AscenseurGateway;
import fr.pantheonsorbonne.ufr27.miage.dto.Ascenseur;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@ApplicationScoped
public class AscenseurServiceImpl implements AscenseurService{

    @PersistenceContext
    EntityManager em;

    @Inject
    AscenseurGateway ascenseurGateway;

    @Override
    @Transactional
    public Ascenseur createNewAscenseur(int id, int etage, boolean isGoingUp, boolean isInError, boolean isDoorOpen) {
        Ascenseur a = new Ascenseur(id, etage, isGoingUp, isInError, isDoorOpen);
        em.persist(a);
        return a;
    }

    @Override
    @Transactional
    public void moveToEtage(Ascenseur a,int etage) {
         Ascenseur ascenseur = em.find(Ascenseur.class, a);
         ascenseur.setEtage(etage);

    }

    @Override
    @Transactional
    public void openDoor(Ascenseur a){
        Ascenseur ascenseur = em.find(Ascenseur.class, a);
        ascenseur.setDoorOpen(true);
    }

    @Override
    @Transactional
    public void closeDoor(Ascenseur a){
        Ascenseur ascenseur = em.find(Ascenseur.class, a);
        ascenseur.setDoorOpen(false);
    }

    @Override
    @Transactional
    public void goDown(Ascenseur a){
        Ascenseur ascenseur = em.find(Ascenseur.class, a);
        ascenseur.setGoingUp(false);
    }

    @Override
    @Transactional
    public void goUp(Ascenseur a){
        Ascenseur ascenseur = em.find(Ascenseur.class, a);
        ascenseur.setGoingUp(true);
    }

    @Override
    @Transactional
    public Ascenseur getAscenseur(int id){
        Ascenseur ascenseur = em.find(Ascenseur.class, id);
        return ascenseur;
    }

    @Override
    @Transactional
    public void move(int idAscenseur, int etage){
        Ascenseur ascenseur = em.find(Ascenseur.class, idAscenseur);
        ascenseur.setEtage(etage);
        ascenseur.setDoorOpen(true);
        ascenseurGateway.AscenseurIsOpen(idAscenseur);
    }





}