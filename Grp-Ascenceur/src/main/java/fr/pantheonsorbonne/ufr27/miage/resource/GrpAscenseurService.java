package fr.pantheonsorbonne.ufr27.miage.resource;


import fr.pantheonsorbonne.ufr27.miage.model.passenger;
import fr.pantheonsorbonne.ufr27.miage.service.AppelerAscenseur;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.*;

@Path("/")
public class GrpAscenseurService {
    @PersistenceContext
    EntityManager em;

    @Inject
    AppelerAscenseur appelerAscenseur;

    @Inject
    fr.pantheonsorbonne.ufr27.miage.camel.grpAscenseurGateway grpAscenseurGateway;

    @Path("/ascenseur/{color}")
    @GET
    public void getAscenseur(@PathParam("color") String color) {
        //retourne ascenseur avec porte ouverte
        appelerAscenseur.getAscenseur(color);

    }

    @Path("/group/{color}/etage/{etage}")
    @GET
    public String call(@PathParam("color") String color, @PathParam("etage") int etage) {
        //Appel tous les ascenseur d'une couleur à l'etage

        appelerAscenseur.callAscenseur(color, etage);

        return "Vous avez appelé les ascenseurs " + color;
    }

    @Path("/ascenseur/{id}/{passengerName}")
    @POST
    public passenger entrer(@PathParam("id") int id, @PathParam("passengerName") String name) {
        //Usager entre dans l'ascenseur id

        return appelerAscenseur.entrer(id,name);
    }

    @Path("/etage/{etage}/ascenseur/{idAscenseur}")
    @GET
    public String etageSelect(@PathParam("etage") int etage, @PathParam("idAscenseur") int idAscenseur) {
        //Selectionne l'étage auquel veut se rendre l'usager

        appelerAscenseur.select(etage,idAscenseur);

        return "Vous êtes au  " + etage + "em étage";
    }

    @Path("/passager/{passengerId}")
    @DELETE
    public void sortir(@PathParam("passengerId") int id) {
        //Usager entre dans l'ascenseur id

        appelerAscenseur.sortir(id);
    }



}