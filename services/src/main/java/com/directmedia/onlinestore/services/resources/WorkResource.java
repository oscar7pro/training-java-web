/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.directmedia.onlinestore.services.resources;

import com.directmedia.onlinestore.officecore.entity.Artist;
import com.directmedia.onlinestore.officecore.entity.Catalogue;
import com.directmedia.onlinestore.officecore.entity.Work;
import java.util.Set;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author jnesis
 */
@Path("/work")
public class WorkResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Set<Work> liste() {
        System.out.println("LISTE!!!!!");
        if (Catalogue.listOfWorks.isEmpty()) {

            Artist tomCruise = new Artist("Tom Cruise");
            Artist michaelJackson = new Artist("Michael Jackson");
            Artist louisDeFunes = new Artist("Louis De Funès");

            Work minorityReport = new Work("Minority Report");
            Work bad = new Work("Bad");
            Work leGendarmeDeSaintTropez = new Work("Le gendarme de Saint-Tropez");

            minorityReport.setMainArtist(tomCruise);
            bad.setMainArtist(michaelJackson);
            leGendarmeDeSaintTropez.setMainArtist(louisDeFunes);

            minorityReport.setRelease(2002);
            bad.setRelease(1987);
            leGendarmeDeSaintTropez.setRelease(1964);

            minorityReport.setSummary("Minority Report place le spectateur dans un futur proche cyberpunk, une dystopie dont le cadre est à Washington de 2054 où des êtres humains mutants, les précogs, peuvent prédire les crimes à venir grâce à leur don de prescience");
            bad.setSummary("Bad est le septième album de Michael Jackson et son 3e album solo chez Epic/Sony et le 3e et dernier album co-produit par Quincy Jones. C'est l'un des albums les plus vendus de l'histoire et celui qui contient le plus de morceaux classés no 1 dans les palmarès.");
            leGendarmeDeSaintTropez.setSummary("le film raconte les aventures de Ludovic Cruchot, un gendarme très « service-service », muté dans la cité balnéaire de Saint-Tropez, sur la côte d'Azur, avec le grade de maréchal-des-logis-chef.");

            minorityReport.setGenre("Science Fiction");
            bad.setGenre("Pop");
            leGendarmeDeSaintTropez.setGenre("Comédie");

            Catalogue.listOfWorks.add(minorityReport);
            Catalogue.listOfWorks.add(bad);
            Catalogue.listOfWorks.add(leGendarmeDeSaintTropez);

        }

        return Catalogue.listOfWorks;
    }

    /*
    Erreur dans le cours
    @POST
    public Response ajout(@Context UriInfo uriInfo) {

        boolean success = true;

        Work nouvelleOeuvre = new Work(uriInfo.getQueryParameters().getFirst("title"));
        nouvelleOeuvre.setGenre(uriInfo.getQueryParameters().getFirst("genre"));
        try {
            nouvelleOeuvre.setRelease(Integer.parseInt(uriInfo.getQueryParameters().getFirst("release")));
        } catch (NumberFormatException nfe) {
            success = false;
        }
        nouvelleOeuvre.setSummary(uriInfo.getQueryParameters().getFirst("summary"));
        nouvelleOeuvre.setMainArtist(new Artist(uriInfo.getQueryParameters().getFirst("artist")));

        Catalogue.listOfWorks.add(nouvelleOeuvre);

        return Response.status(Response.Status.CREATED).build();
    }*/
    
    @POST
    public Response ajout(@FormParam("title") String title,@FormParam("genre") String genre,@FormParam("release") int release,@FormParam("summary") String summary,@FormParam("artist") String artist) {

        boolean success = true;

        Work nouvelleOeuvre = new Work(title);
        nouvelleOeuvre.setGenre(genre);
        nouvelleOeuvre.setRelease(release);
        nouvelleOeuvre.setSummary(summary);
        nouvelleOeuvre.setMainArtist(new Artist(artist));
        Catalogue.listOfWorks.add(nouvelleOeuvre);
        return Response.status(Response.Status.CREATED).build();
    }
}