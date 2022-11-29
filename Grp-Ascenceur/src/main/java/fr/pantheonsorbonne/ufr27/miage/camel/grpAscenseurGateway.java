package fr.pantheonsorbonne.ufr27.miage.camel;

import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;


import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.io.IOException;

@ApplicationScoped
public class grpAscenseurGateway {

    @Inject
    CamelContext camelContext;

    public void move(int idAscenseur) {
        try (ProducerTemplate producerTemplate = camelContext.createProducerTemplate()) {
            producerTemplate.sendBody("direct:move", idAscenseur);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


}

