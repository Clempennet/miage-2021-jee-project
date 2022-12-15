package fr.pantheonsorbonne.ufr27.miage.service;

import fr.pantheonsorbonne.ufr27.miage.camel.techGateway;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@ApplicationScoped
public class techServiceImpl implements techService {

 @Inject
 techGateway techGateway;


    @Override
    @Transactional
    public void error(int id) {
        System.out.println("répare l'ascenseur");
        techGateway.repair(id);
    }
}
