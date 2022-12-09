package fr.pantheonsorbonne.ufr27.miage.resource;


import fr.pantheonsorbonne.ufr27.miage.camel.grpAscenseurGateway;
import fr.pantheonsorbonne.ufr27.miage.model.Usager;
import fr.pantheonsorbonne.ufr27.miage.service.AppelerAscenseur;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import java.util.List;

@Path("/")
public class GrpAscenseurService {
    @PersistenceContext
    EntityManager em;

    @Inject
    AppelerAscenseur appelerAscenseur;

    @Inject
    fr.pantheonsorbonne.ufr27.miage.camel.grpAscenseurGateway grpAscenseurGateway;



    @Path("/group/{color}")
    @GET
    public String call(@PathParam("color") String color) {
        //Appel tous les ascenseur d'une couleur
        Usager u = em.find(Usager.class,1);
        grpAscenseurGateway.callAscenseur(color, u.getEtage());

        return "Vous avez appelé les ascenseurs " + color;
    }

    @Path("/ascenseur/{id}")
    @GET
    public String entrer(@PathParam("id") int id) {
        //Usager entre dans l'ascenseur id
        grpAscenseurGateway.entrer(id);
        return "Vous êtes entré dans l'ascenseur  "+ id;
    }

    @Path("/etage/{etage}")
    @GET
    public String etageSelect(@PathParam("etage") int etage) {
        //Selectionne l'étage auquel veut se rendre l'usager
        Usager u = em.find(Usager.class,1);
        grpAscenseurGateway.select(etage,u.getIdAscenseur());

        return "Vous êtes au  " + etage + "em étage";
    }

    @Path("/sortie")
    @GET
    public String sortir() {
        //L'usager sort de l'ascenseur
        Usager u = em.find(Usager.class,1);
        grpAscenseurGateway.fin(u.getIdAscenseur());

        return "Vous êtes sorti ";
    }



}