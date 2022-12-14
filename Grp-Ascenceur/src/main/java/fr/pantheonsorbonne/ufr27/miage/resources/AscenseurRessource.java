package fr.pantheonsorbonne.ufr27.miage.resources;

import fr.pantheonsorbonne.ufr27.miage.dto.Ascenseur;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Collection;
import java.util.List;

@Path("group")
@RegisterRestClient(configKey = "group-api")
public interface AscenseurRessource {

    @Path("{group}/{sens}")
    @POST
    Response callAscenceur(@PathParam("group") String group, @PathParam("sens") String sens);

    @Path("{group}/{sens}/ascenseurs")
    @GET
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    Collection<Ascenseur> getAvailableAtFloor(@PathParam("group") String group, @PathParam("sens") String sens);

    @Path("{group}/{sens}/ascenseurs/{idASc}")
    @GET
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    List<Integer> getServedFloor(@PathParam("group") String group, @PathParam("idASc") String idASc);

    @Path("{group}/{sens}/ascenseurs/{idAsc}/{numFloor}")
    @PUT
    Response selectFloor(@PathParam("numFloor") String numFloor, @PathParam("idAsc") String idAsc);

    //Quel ascenseur
    //recup un id asc
    //getStates
    //getFloor
    //getAvailability
    //getDEservedFloors
}
