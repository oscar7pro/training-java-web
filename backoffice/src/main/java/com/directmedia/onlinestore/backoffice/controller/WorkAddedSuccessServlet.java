/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.directmedia.onlinestore.backoffice.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author adonay
 */
@WebServlet(name = "WorkAddedSuccessServlet", urlPatterns = {"/work-added-success"})
public class WorkAddedSuccessServlet extends HttpServlet {



    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
         PrintWriter out = response.getWriter();
         response.setContentType("text/html");
       
          out.print("<html><head>"
                + "<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\" integrity=\"sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z\" crossorigin=\"anonymous\"></head>"
                + "<body><div class=\"container\"><h1 class=\"list-group-item list-group-item-action active \">L'oeuvre a été ajoutée, son identifiant (interne) : "+request.getAttribute("identifiantOuevre")+ " " +"<a class=\"text-light\"  href=\"home.jsp\">Retourner à la page d'accueil</a></h1><br/>");
             
         out.print("</div></body></html>");
    }


}
