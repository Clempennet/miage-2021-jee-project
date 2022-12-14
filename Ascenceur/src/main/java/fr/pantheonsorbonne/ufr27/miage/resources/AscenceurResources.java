package fr.pantheonsorbonne.ufr27.miage.resources;

import fr.pantheonsorbonne.ufr27.miage.dto.Ascenseur;
import fr.pantheonsorbonne.ufr27.miage.exception.AscenseurHSException;
import fr.pantheonsorbonne.ufr27.miage.exception.NoAscenseurAvailableException;
import fr.pantheonsorbonne.ufr27.miage.exception.NotServedFloorException;
import fr.pantheonsorbonne.ufr27.miage.service.FloorService;

import javax.inject.Inject;
import javax.persistence.NoResultException;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.Collection;
import java.util.List;

@Path("group")
public class AscenceurResources {

    @Inject
    FloorService floorService;

    @Path("{group}/{sens}")
    @POST
    public Response callAscenceur(@PathParam("group") String group, @PathParam("sens") String sens){
        try {
            floorService.verifyAvailabilityGroup(group,sens);
            return Response.created(URI.create(group+"/ascenseurs")).build();
        }
        catch (NoAscenseurAvailableException e){
            return Response.status(Response.Status.SERVICE_UNAVAILABLE).build();
        }
    }

    @Path("{group}/{sens}/etage/{floor}/ascenseurs")
    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Collection<Ascenseur> getAvailableAtFloor(@PathParam("group") String group, @PathParam("sens") String sens, @PathParam("floor") String floor){
        try {
            return floorService.getAvailableAtFloor(group,sens,floor);
        }
        catch (NoAscenseurAvailableException e){
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
    }

    @Path("{group}/{sens}/etage/{floor}/ascenseurs/{idASc}")
    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<Integer> getServedFloor(@PathParam("group") String group, @PathParam("idASc") String idASc){
        try {
            return floorService.getServedFloors(group,Integer.parseInt(idASc));
        } catch (AscenseurHSException e) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
    }

    @Path("{group}/{sens}/etage/{floor}/ascenseurs/{idAsc}/{numFloor}")
    @PUT
    public Response selectFloor(@PathParam("numFloor") String numFloor, @PathParam("idAsc") String idAsc, @PathParam("group") String group){
        try {
            floorService.goToFloor(numFloor, group, Integer.parseInt(idAsc));
            return Response.status(Response.Status.NO_CONTENT).build();
        } catch (AscenseurHSException | NotServedFloorException e ) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @Path("{group}/{sens}/etage/{floor}/ascenseurs/{idAsc}/{numFloor}")
    @DELETE
    public Response deleteFloor(@PathParam("numFloor") String numFloor, @PathParam("idAsc") String idAsc){
        try {
             floorService.deleteFloor(numFloor, Integer.parseInt(idAsc));
            return Response.status(Response.Status.NO_CONTENT).build();

        }
        catch (NotServedFloorException | NoResultException e){
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}
