package fr.pantheonsorbonne.ufr27.miage.camel;

import fr.pantheonsorbonne.ufr27.miage.model.Ascenseur;
import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@ApplicationScoped
public class TechGateway {

    @Inject
    CamelContext camelContext;

    public void sendHsAlert(Ascenseur ascenseur){
        try(ProducerTemplate producerTemplate = camelContext.createProducerTemplate()){
            producerTemplate.sendBodyAndHeader("direct:technician", "Ascenseur n°"+ascenseur.getId() + " appartenant au groupe "+ascenseur.getGrpColor()+" présent à l'étage "+ascenseur.getCurrentEtage()+" est HORS SERVICE depuis "+ LocalDate.now(), "GrpAscenseur", ascenseur.getGrpColor());
        }
        catch(IOException e){
            throw new RuntimeException();
        }
    }

    public void sendReport(Collection<Ascenseur> ascenseurs){
        try(ProducerTemplate producerTemplate = camelContext.createProducerTemplate()){
            List<fr.pantheonsorbonne.ufr27.miage.dto.Ascenseur> allAscenceur = new ArrayList<>();
            for(Ascenseur as : ascenseurs){
                new fr.pantheonsorbonne.ufr27.miage.dto.Ascenseur(as.getId(), as.getCurrentEtage(), as.getIsGoingUp(), as.getIsInError(), as.getIsDoorOpen(),as.getServedFloors(), as.getSelectedFloors(), as.getGrpColor());
            }
            producerTemplate.sendBodyAndHeader("direct:report", allAscenceur, "DateReport", LocalDate.now());
        }
        catch(IOException e){
            throw new RuntimeException();
        }
    }
}
