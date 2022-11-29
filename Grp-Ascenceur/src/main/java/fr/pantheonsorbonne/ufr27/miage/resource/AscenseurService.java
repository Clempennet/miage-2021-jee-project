package fr.pantheonsorbonne.ufr27.miage.resource;


import fr.pantheonsorbonne.ufr27.miage.dto.Ascenseur;
import fr.pantheonsorbonne.ufr27.miage.dto.GrpAscenseur;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.jboss.resteasy.annotations.jaxrs.PathParam;


import java.util.Collection;


@Path("/Ascenseur")
@RegisterRestClient(configKey = "vendor-api")
public interface AscenseurService {


    @Path("/listAscenseur/{color}")
    @GET
    Collection<Ascenseur> getAscenseurByColor(@PathParam String color);

    @Path("/listAscenseur")
    @GET
    Collection<Ascenseur> getAscenseur();

    @Path("/grpAscenseur/{color}")
    @GET
    GrpAscenseur getGrpAscenseur();
}
