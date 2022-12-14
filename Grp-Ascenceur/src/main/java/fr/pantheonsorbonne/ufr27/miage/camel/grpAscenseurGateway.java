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
public class grpAscenseurGateway {

    @Inject
    CamelContext camelContext;

    public void move(int idAscenseur) {
        System.out.println("moooooove");
        try (ProducerTemplate producerTemplate = camelContext.createProducerTemplate()) {
            producerTemplate.sendBody("direct:move", idAscenseur);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void entrer(int id){
        try (ProducerTemplate producerTemplate = camelContext.createProducerTemplate()) {
            producerTemplate.sendBody("direct:entrer", id);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void select(int etage, int ascenseurId){
        List<Integer> l = new ArrayList<>();
        l.add(etage);
        l.add(ascenseurId);
        try (ProducerTemplate producerTemplate = camelContext.createProducerTemplate()) {

            producerTemplate.sendBody("direct:select", l);

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

    public void fin(int idAscenseur) {
        try (ProducerTemplate producerTemplate = camelContext.createProducerTemplate()) {
            producerTemplate.sendBody("direct:fin", idAscenseur);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void getAscenseur(String color) {
        try (ProducerTemplate producerTemplate = camelContext.createProducerTemplate()) {
            producerTemplate.sendBody("direct:getAscenseur", color);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

