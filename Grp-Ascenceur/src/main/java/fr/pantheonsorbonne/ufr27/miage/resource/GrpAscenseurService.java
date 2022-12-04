package fr.pantheonsorbonne.ufr27.miage.resource;


import fr.pantheonsorbonne.ufr27.miage.camel.grpAscenseurGateway;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import java.util.List;

@Path("GrpAscenseur")
public class GrpAscenseurService {
    @PersistenceContext
    EntityManager em;

    @Inject
    UsagerService usagerService;

    @Inject
    fr.pantheonsorbonne.ufr27.miage.camel.grpAscenseurGateway grpAscenseurGateway;


    @Path("getAscenseur")
    @GET
    public List getAscenseur() {
        return em.createQuery(
                        "SELECT c FROM Ascenseur c")

                .getResultList();
    }

    @Path("")
    @GET
    public String getGrp() {
        if (usagerService.u.getEtageActuel() == 9 || usagerService.u.getEtageActuel() == 0) {
            return "R , J , V";
        } else if (usagerService.u.getEtageActuel() <= 9) {
            return "J";
        } else if (usagerService.u.getEtageActuel() > 9 && usagerService.u.getEtageActuel() <= 20) {
            return "R";
        } else if (usagerService.u.getEtageActuel() > 20) {
            return "V";
        }
        return "";
    }

    @Path("/{color}")
    @GET
    public String call(@PathParam("color") String color) {
        grpAscenseurGateway.callAscenseur(color, 14);

        return "call " + color;
    }





}