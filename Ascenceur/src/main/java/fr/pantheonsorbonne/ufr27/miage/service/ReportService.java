package fr.pantheonsorbonne.ufr27.miage.service;

import fr.pantheonsorbonne.ufr27.miage.camel.TechGateway;
import fr.pantheonsorbonne.ufr27.miage.dao.AscenseurDAO;

import javax.inject.Inject;


public class ReportService {

    @Inject
    AscenseurDAO ascDAO;

    @Inject
    TechGateway techGateway;

    public void sendReport(){
         techGateway.sendReport(ascDAO.getStates());
    }
}
