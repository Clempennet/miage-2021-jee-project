package fr.pantheonsorbonne.ufr27.miage.camel;

import fr.pantheonsorbonne.ufr27.miage.dto.Ascenseur;
import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;

import javax.inject.Inject;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Collection;

public class TechGateway {

    @Inject
    CamelContext camelContext;

    public void sendHsAlert(Ascenseur ascenseur){
        try(ProducerTemplate producerTemplate = camelContext.createProducerTemplate()){
            producerTemplate.sendBodyAndHeader("direct:technician", ascenseur.getId() +" "+ LocalDate.now(), "GrpAscenseur", ascenseur.getColor());
        }
        catch(IOException e){
            throw new RuntimeException();
        }
    }

    public void sendReport(Collection<Ascenseur> ascenseurs){
        try(ProducerTemplate producerTemplate = camelContext.createProducerTemplate()){
            producerTemplate.sendBodyAndHeader("direct:report", ascenseurs, "DateReport", LocalDate.now());
        }
        catch(IOException e){
            throw new RuntimeException();
        }
    }
}
