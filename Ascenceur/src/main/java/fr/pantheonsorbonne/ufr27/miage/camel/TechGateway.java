package fr.pantheonsorbonne.ufr27.miage.camel;

import fr.pantheonsorbonne.ufr27.miage.dto.Ascenseur;
import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;

import javax.inject.Inject;
import java.io.IOException;

public class TechGateway {

    @Inject
    CamelContext camelContext;


    public void sendHsAlert(Ascenseur asc){
        try(ProducerTemplate producerTemplate = camelContext.createProducerTemplate()){
            producerTemplate.sendBodyAndHeader("direct:technicien", asc, "GrpAscenseur", asc.getGrpAscenseur());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
