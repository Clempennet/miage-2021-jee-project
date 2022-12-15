package fr.pantheonsorbonne.ufr27.miage.camel;

import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@ApplicationScoped
public class techGateway {

    @Inject
    CamelContext camelContext;


    public void repair(int id) {
        try (ProducerTemplate producerTemplate = camelContext.createProducerTemplate()) {
            producerTemplate.sendBody("direct:repair", id);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

