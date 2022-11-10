package fr.pantheonsorbonne.ufr27.miage.resources;

import fr.pantheonsorbonne.ufr27.miage.dto.Ascenceur;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/ascenceur")
public class AscenceurRessource {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Ascenceur getState(){
        return new Ascenceur(1, false,false,true) ;
    }
}
