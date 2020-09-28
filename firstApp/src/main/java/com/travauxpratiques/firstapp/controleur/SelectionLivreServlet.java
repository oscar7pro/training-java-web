/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.travauxpratiques.firstapp.controleur;


import com.travauxpratiques.firstappcore.Livre;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



/**
 *
 * @author adonay
 */
@WebServlet(name = "SelectionLivreServlet", urlPatterns = {"/selection-livre"})
public class SelectionLivreServlet extends HttpServlet {


    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
         String numeroSession = session.getId();
            String identifiantLivre = request.getParameter("id");
            
            List<Livre> liste = (List<Livre>)session.getAttribute("listeLivres");
            if(liste == null) {
                liste = new ArrayList<>();
                session.setAttribute("listeLivres", liste);
            }
           
           
            
            Livre livre = new Livre();
            livre.setNumeroLivre(Integer.parseInt(identifiantLivre));
            liste.add(livre);
            
            
            PrintWriter out = response.getWriter();
            out.print(
               "<!doctype html>\n" +
                "<html lang=\"en\">\n" +
                    "<head>\n" +
                    "  <meta charset=\"utf-8\">\n" +
                    "  <title>Cocktails</title>\n" +
                    "  <base href=\"/\">\n" +
                    "  <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\" integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" crossorigin=\"anonymous\">\n" +
                    "\n" +
                    "  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
                    "  <link rel=\"icon\" type=\"image/x-icon\" href=\"favicon.ico\">\n" +
                    "</head>\n" +
                    "<body>\n" +
                    " <div class=\"container text-primary\"> <h1>Merci d'avoir choisir le livre " +identifiantLivre+ "</h1>"+
                    " <span><a href=\"/firstApp/choix-du-livre.html\">Cliquer ici pour ajouter un autre livre</a></span><br>"+ 
                    " <span><a href=\"/firstApp/payer-livre.html\">Cliquer ici pour payer</a></span><br>"+
                    
                    "</div>\n" +
                    "</body>\n" +
                "</html>"
       );
    }


}
