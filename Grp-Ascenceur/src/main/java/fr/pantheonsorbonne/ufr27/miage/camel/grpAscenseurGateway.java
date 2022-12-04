package fr.pantheonsorbonne.ufr27.miage.camel;

import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;


import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.io.IOException;
import java.util.Objects;

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

    public void callAscenseur(String color, int etage){

        if(Objects.equals(color, "R")){

            try (ProducerTemplate producerTemplate = camelContext.createProducerTemplate()) {
                producerTemplate.sendBody("direct:callR", etage);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        if(Objects.equals(color, "J")){

            try (ProducerTemplate producerTemplate = camelContext.createProducerTemplate()) {
                producerTemplate.sendBody("direct:callJ", etage);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        if(Objects.equals(color, "V")){

            try (ProducerTemplate producerTemplate = camelContext.createProducerTemplate()) {
                producerTemplate.sendBody("direct:callV", etage);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }

}

