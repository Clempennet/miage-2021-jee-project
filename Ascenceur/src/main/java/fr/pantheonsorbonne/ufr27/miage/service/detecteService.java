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
public class detecteService extends Thread{

    @PersistenceContext
    EntityManager em;

    @Inject
    AscenseurGateway ascenseurGateway;

    public void run(){

        for (int i=1;i<=10;i++){
            Ascenseur a = em.find(Ascenseur.class, i);
            if(a.isInError()){
                ascenseurGateway.error(a.getId());
            }
        }
        try {

            Thread.sleep(5000) ;
        }  catch (InterruptedException e) {

            // gestion de l'erreur
        }
    }


}
