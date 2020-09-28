
package com.directmedia.onlinestore.frontoffice.controller;


import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.directmedia.onlinestore.officecore.entity.Artist;
import com.directmedia.onlinestore.officecore.entity.Work;
import com.directmedia.onlinestore.officecore.entity.Catalogue;


/**
 *
 * @author adonay
 */
@WebServlet(name = "CatalogueServlet", urlPatterns = {"/catalogue"})
public class CatalogueServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        if(Catalogue.listOfWorks.isEmpty()) {
            
            Artist artist1 = new Artist("Datouda");
    	Artist artist2 = new Artist("SAou");
    	Artist artist = new Artist("Erico");
        
       
    	
    	Work workOne = new Work("Start up");
    	Work workSecond = new Work("Big up");
    	Work work = new Work("Do it");
        
        workOne.setMainArtist(artist1);
        workSecond.setMainArtist(artist2);
        work.setMainArtist(artist);
        
        workOne.setRelease(2020);
        workSecond.setRelease(1999);
        work.setRelease(1980);
        
        workOne.setSummary("un commencement rapide");
        workSecond.setSummary("le travail des rte");
        work.setSummary("il le faut");
        
        workOne.setGenre("fantastique");
        workSecond.setGenre("fiction");
        work.setGenre("music");
        
        Catalogue.listOfWorks.add(work);
        Catalogue.listOfWorks.add(workOne);
        Catalogue.listOfWorks.add(workSecond);
        }
        
        out.print("<html><head>"
                + "<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\" integrity=\"sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z\" crossorigin=\"anonymous\"></head>"
                + "<body><div class=\"container\"><h1 class=\"list-group-item list-group-item-action active\">Oeuvres des catalogues</h1><br/>");
        
        for (Work workOfList : Catalogue.listOfWorks) {
                                out.println("<ul class=\"list-group\"><li class=\"list-group-item\">");
				out.print("<a href=\"work-details?id="+workOfList.getId()+ "\"s>");
				out.println( workOfList.getTitle() + " ( " + workOfList.getRelease() + " )");
                                out.println("</a>");
                                out.println("</li></ul>");
		}
        
        out.print("</div></body></html>");
      }
}
