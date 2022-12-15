package fr.pantheonsorbonne.ufr27.miage.service;

import fr.pantheonsorbonne.ufr27.miage.camel.TechGateway;
import fr.pantheonsorbonne.ufr27.miage.dao.AscenseurDAO;
import fr.pantheonsorbonne.ufr27.miage.dto.Ascenseur;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.Collection;


@ApplicationScoped
public class ReportServiceImpl implements ReportService {

    @Inject
    AscenseurDAO ascDAO;

    @Inject
    TechGateway techGateway;

    @Override
    public void sendReport(){
         techGateway.sendReport(ascDAO.getStates());
    }


}
