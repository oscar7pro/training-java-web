/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.travauxpratiques.firstapp.resources;

import com.travauxpratiques.firstappcore.Produit;
import com.travauxpratiques.firstappcore.Somme;
import com.travauxpratiques.firstappcore.SommeEtProduit;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author adonay
 */
@Path("/calculation")
public class CalculationResource {
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/somme-et-produit")
    public SommeEtProduit sommeEtProduit (@QueryParam("nombre1") final int nombre1, @QueryParam("nombre2") final int nombre2 ) {
         
     
            
              int sommeNumerique = nombre1 + nombre2;
              int produitNumerique = nombre1 * nombre2;
              
            SommeEtProduit sommeEtProduit = new SommeEtProduit();
            Somme somme = new Somme();
            somme.setNumerique(sommeNumerique);
            somme.setTexte("douze");
            
             Produit produit = new Produit();
            produit.setNumerique(produitNumerique);
            produit.setTexte("trente-deux");
                        
            sommeEtProduit.setSomme(somme);
            sommeEtProduit.setProduit(produit);
            
            return sommeEtProduit;
            
          
    }
}
