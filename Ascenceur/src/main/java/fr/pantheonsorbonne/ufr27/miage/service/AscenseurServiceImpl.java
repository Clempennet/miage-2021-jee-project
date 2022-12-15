package fr.pantheonsorbonne.ufr27.miage.service;

import fr.pantheonsorbonne.ufr27.miage.camel.AscenseurGateway;
import fr.pantheonsorbonne.ufr27.miage.model.Ascenseur;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.ArrayList;
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

    @Override
    @Transactional
    public void getAscenseur(String color) {
        List<Integer> l = new ArrayList<>();
        if(color.equals("R")){
            for (int i = 1;i<=5;i++){
                Ascenseur a = em.find(Ascenseur.class, i);
                if(a.isInError()==false){
                    l.add(a.getEtage());
                }
            }
        }

        if(color.equals("J")){
            for (int i = 6;i<=7;i++){
                Ascenseur a = em.find(Ascenseur.class, i);
                if(a.isInError()==false){
                    l.add(a.getEtage());
                }
            }
        }
        if(color.equals("V")){
            for (int i = 8;i<=10;i++){
                Ascenseur a = em.find(Ascenseur.class, i);
                if(a.isInError()==false){
                    l.add(a.getEtage());
                }
            }
        }
        System.out.println(l);
    }

    @Override
    @Transactional
    public void repair(int id) {
        Ascenseur a = em.find(Ascenseur.class,id);
        a.setInError(false);
    }


}
