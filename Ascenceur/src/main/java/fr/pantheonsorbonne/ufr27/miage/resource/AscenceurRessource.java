package fr.pantheonsorbonne.ufr27.miage.resource;

import fr.pantheonsorbonne.ufr27.miage.dto.Ascenseur;

import fr.pantheonsorbonne.ufr27.miage.service.AscenseurService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/ascenceur")
public class AscenceurRessource {

    @Inject
    AscenseurService ascenseurService;
    @Path("/{idAscenceur}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Ascenseur getState(@PathParam("idAscenceur") int id){

        return ascenseurService.getAscenseur(id);
    }

    @Path(("/create"))
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public void createNewAscenseur(){
        ascenseurService.createNewAscenseur(1,1,false,false,true);
    }
}
