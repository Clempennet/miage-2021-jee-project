package fr.pantheonsorbonne.ufr27.miage.camel;

import fr.pantheonsorbonne.ufr27.miage.model.Ascenseur;
import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.io.IOException;
import java.util.List;

@ApplicationScoped
public class AscenseurGatewayImpl implements AscenseurGateway {

    @Inject
    CamelContext camelContext;

    @PersistenceContext
    EntityManager em;


    @Override
    @Transactional
    public void sendEtageActuelR(int etage) {
        Ascenseur ascenseur = em.find(Ascenseur.class, 1);
        for (int i = 1;i<=5;i++) {
            Ascenseur a = em.find(Ascenseur.class, i);
            if (a.getEtage() == etage) {
                a.setDoorOpen(true);

                return;
            } else {
                if (Math.abs(a.getEtage() - etage) < ascenseur.getEtage()) {
                    ascenseur = a;
                }
            }
        }
        ascenseur.setEtage(etage);
        ascenseur.setDoorOpen(true);
    }

    @Override
    @Transactional
    public void sendEtageActuelJ(int etage) {
        Ascenseur ascenseur = em.find(Ascenseur.class, 1);
        for (int i = 5;i<=7;i++) {
            Ascenseur a = em.find(Ascenseur.class, i);
            if (a.getEtage() == etage) {
                a.setDoorOpen(true);

                return;
            } else {
                if (Math.abs(a.getEtage() - etage) < ascenseur.getEtage()) {
                    ascenseur = a;
                }
            }
        }
        ascenseur.setEtage(etage);
        ascenseur.setDoorOpen(true);
    }

    @Override
    @Transactional
    public void sendEtageActuelV(int etage) {
        Ascenseur ascenseur = em.find(Ascenseur.class, 1);
        for (int i = 8;i<=10;i++) {
            Ascenseur a = em.find(Ascenseur.class, i);
            if (a.getEtage() == etage) {
                a.setDoorOpen(true);

                return;
            } else {
                if (Math.abs(a.getEtage() - etage) < ascenseur.getEtage()) {
                    ascenseur = a;
                }
            }
        }
        ascenseur.setEtage(etage);
        ascenseur.setDoorOpen(true);
    }


    public void appelerTechnicien(int idAscenseur){
        try (ProducerTemplate producerTemplate = camelContext.createProducerTemplate()) {
            producerTemplate.sendBody("direct:technicien",idAscenseur);
            producerTemplate.sendBody("direct:alert",idAscenseur);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

public void AscenseurIsOpen(int idAscenseur){
    try (ProducerTemplate producerTemplate = camelContext.createProducerTemplate()) {
        producerTemplate.sendBody("direct:isOpen",idAscenseur);
    } catch (IOException e) {
        throw new RuntimeException(e);
    }
}

}
