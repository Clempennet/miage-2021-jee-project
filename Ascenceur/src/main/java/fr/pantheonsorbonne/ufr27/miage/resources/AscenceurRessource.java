package fr.pantheonsorbonne.ufr27.miage.resources;

import fr.pantheonsorbonne.ufr27.miage.resources.dto.Ascenseur;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.Arrays;

@Path("/ascenceur")
public class AscenceurRessource {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Ascenseur getState(){
        return new Ascenseur(1, false, false, true, new ArrayList<>(Arrays.asList(9,11,12,13,14,15,16))) ;
    }
}
