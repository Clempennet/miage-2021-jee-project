package fr.pantheonsorbonne.ufr27.miage.service;

import fr.pantheonsorbonne.ufr27.miage.dto.Ascenseur;
import fr.pantheonsorbonne.ufr27.miage.dto.GrpAscenseur;
import fr.pantheonsorbonne.ufr27.miage.model.Usager;


import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
@ApplicationScoped
public class AppelerAscenseurImpl implements AppelerAscenseur {

    @PersistenceContext
    EntityManager em;

    public void alert(){
        System.out.println("ascenseur hs, nous appelons le technicien");
    }

    @Override
    public void entrer() {

    }

    @Override
    public Collection<Ascenseur> getAscenseur() {
        Collection<Ascenseur> ascenseurCollection = new LinkedList<>();
        Ascenseur ascenseur = em.find(Ascenseur.class, 1);
        ascenseurCollection.add(ascenseur);


        return ascenseurCollection;
    }
}
