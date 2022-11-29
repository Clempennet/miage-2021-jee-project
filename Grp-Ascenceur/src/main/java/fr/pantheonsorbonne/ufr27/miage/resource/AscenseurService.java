package fr.pantheonsorbonne.ufr27.miage.resource;


import fr.pantheonsorbonne.ufr27.miage.dto.Ascenseur;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.jboss.resteasy.annotations.jaxrs.PathParam;


import java.util.Collection;


@Path("/Ascenseur")
@RegisterRestClient(configKey = "vendor-api")
public interface AscenseurService {


    @Path("/list/{color}")
    @GET
    Collection<Ascenseur> getAscenseurByColor(@PathParam String color);

    @Path("/list")
    @GET
    Collection<Ascenseur> getAscenseur();
}
