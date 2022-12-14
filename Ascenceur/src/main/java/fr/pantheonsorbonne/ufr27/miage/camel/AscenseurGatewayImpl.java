package fr.pantheonsorbonne.ufr27.miage.camel;

import fr.pantheonsorbonne.ufr27.miage.model.Ascenseur;
import fr.pantheonsorbonne.ufr27.miage.service.AscenseurService;
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

    @Inject
    AscenseurService ascenseurService;


    @Override
    @Transactional
    public void sendEtageActuelR(int etage) {
        Ascenseur ascenseur = em.find(Ascenseur.class, 1);
        for (int i = 1;i<=5;i++) {
            Ascenseur a = em.find(Ascenseur.class, i);
            if (a.getEtage() == etage) {
                a.setDoorOpen(true);
                open(a);


                return;
            } else {
                if (Math.abs(a.getEtage() - etage) < ascenseur.getEtage()) {
                    ascenseur = a;
                }
            }
        }
        ascenseur.setEtage(etage);
        ascenseur.setDoorOpen(true);
        open(ascenseur);

    }



    @Override
    @Transactional
    public void sendEtageActuelJ(int etage) throws InterruptedException {
        Ascenseur ascenseur = em.find(Ascenseur.class, 1);
        for (int i = 6;i<=7;i++) {
            Ascenseur a = em.find(Ascenseur.class, i);
            if (a.getEtage() == etage) {
                a.setDoorOpen(true);
                open(a);

                return;
            } else {
                if (Math.abs(a.getEtage() - etage) < ascenseur.getEtage()) {
                    ascenseur = a;
                }
            }
        }
        ascenseur.setEtage(etage);
        ascenseur.setDoorOpen(true);
        open(ascenseur);

    }

    @Override
    @Transactional
    public void sendEtageActuelV(int etage) throws InterruptedException {
        Ascenseur ascenseur = em.find(Ascenseur.class, 1);
        for (int i = 8;i<=10;i++) {
            Ascenseur a = em.find(Ascenseur.class, i);
            if (a.getEtage() == etage) {
                a.setDoorOpen(true);
                open(a);


                return;
            } else {
                if (Math.abs(a.getEtage() - etage) < ascenseur.getEtage()) {
                    ascenseur = a;
                }
            }
        }
        ascenseur.setEtage(etage);
        ascenseur.setDoorOpen(true);
        open(ascenseur);


    }
    @Override
    @Transactional
    public void entrer(int id){
        Ascenseur a = em.find(Ascenseur.class,id);
        if(a.isDoorOpen()){
            try (ProducerTemplate producerTemplate = camelContext.createProducerTemplate()) {
                producerTemplate.sendBody("direct:entrer",a.getId());

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    @Transactional
    public void fin(int idAscenseur){
        Ascenseur a = em.find(Ascenseur.class,idAscenseur);
        a.setDoorOpen(false);
        try (ProducerTemplate producerTemplate = camelContext.createProducerTemplate()) {
            producerTemplate.sendBody("direct:fin",a.getEtage());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void sortir(int etage) {
        try (ProducerTemplate producerTemplate = camelContext.createProducerTemplate()) {
            producerTemplate.sendBody("direct:sortir",etage);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void getGroup(List l) {
        try (ProducerTemplate producerTemplate = camelContext.createProducerTemplate()) {
            producerTemplate.sendBody("direct:getGroup",l);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void porte(int id) {
        try (ProducerTemplate producerTemplate = camelContext.createProducerTemplate()) {
            producerTemplate.sendBody("direct:porte",id);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void getAscenseur(List<Integer> l) {
        try (ProducerTemplate producerTemplate = camelContext.createProducerTemplate()) {
            producerTemplate.sendBody("direct:getAscenseur",l);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void open(Ascenseur a){
        try (ProducerTemplate producerTemplate = camelContext.createProducerTemplate()) {
            producerTemplate.sendBody("direct:open",a.getId());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
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
