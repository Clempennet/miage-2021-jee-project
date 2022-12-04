package fr.pantheonsorbonne.ufr27.miage.resource;


import fr.pantheonsorbonne.ufr27.miage.model.Ascenseur;
import fr.pantheonsorbonne.ufr27.miage.model.Usager;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

@Path("usager")
public class UsagerService {
    @PersistenceContext
    EntityManager em;

    public Usager u;


    @Path("/creer/{nom}/{etage}")
    @GET
    public Usager creerUsager(@PathParam("nom") String nom, @PathParam("etage") int etage) {
        u = new Usager(nom,etage,false);
        return u;
    }

    @Path("")
    @GET
    public Usager Usager() {

        return u;
    }

}

