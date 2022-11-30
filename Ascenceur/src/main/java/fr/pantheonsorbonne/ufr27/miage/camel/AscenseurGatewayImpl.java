package fr.pantheonsorbonne.ufr27.miage.camel;

import fr.pantheonsorbonne.ufr27.miage.dto.Ascenseur;
import fr.pantheonsorbonne.ufr27.miage.model.Venue;
import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.IOException;

@ApplicationScoped
public class AscenseurGatewayImpl implements AscenseurGateway {

    @Inject
    CamelContext camelContext;

    @PersistenceContext
    EntityManager em;


    @Override
    public void sendEtageActuel1() {
        Ascenseur ascenseur = em.find(Ascenseur.class, 1);
        if(ascenseur.isInError()==true){
            appelerTechnicien(1);
        }
        else {
            try (ProducerTemplate producerTemplate = camelContext.createProducerTemplate()) {
                producerTemplate.sendBody("direct:etageActuel1", ascenseur.getEtage());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
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
