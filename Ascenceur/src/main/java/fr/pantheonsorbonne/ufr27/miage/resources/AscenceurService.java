package fr.pantheonsorbonne.ufr27.miage.resources;

import fr.pantheonsorbonne.ufr27.miage.dto.Ascenseur;
import fr.pantheonsorbonne.ufr27.miage.exception.NoAscenseurAvailableException;
import fr.pantheonsorbonne.ufr27.miage.service.FloorService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Path("group")
public class AscenceurService {

    @Inject
    FloorService floorService;

    @Path("{group}")
    @POST
    public Response callAscenceur(@PathParam("group") String group) throws NoAscenseurAvailableException {
        try {
            floorService.verifyAvailabilityGroup(group);
            return Response.created(URI.create(group+"/ascenseurs")).build();
        }
        catch (NoAscenseurAvailableException e){
            return Response.status(Response.Status.SERVICE_UNAVAILABLE).build();
        }

    }

    @Path("{group}/ascenseurs")
    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Collection<Ascenseur> getAvailableAtFloor(@PathParam("group") String group) throws NoAscenseurAvailableException {
        try {
            return floorService.verifyAvailabilityGroup(group);
        }
        catch (NoAscenseurAvailableException e){
            return null;
        }
    }

    //GEt la liste des etages desservi opur un asc donné
    //UPDATE si pas d'ascenseur à l'étage add etage actuel sur l'un des plus proches asc en tant que selected floor
    //UPDATE ajout button (idasc et color group, floor int, tofloor int)
}
