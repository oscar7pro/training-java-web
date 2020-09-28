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
import javax.servlet.http.HttpSession;

/**
 *
 * @author adonay
 */
@WebServlet(name = "HomeServlet", urlPatterns = {"/home"})
public class HomeServlet extends HttpServlet {

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
       response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        
        String login = request.getParameter("login");
        HttpSession session = request.getSession();
        String loginParam = (String) session.getAttribute("login");
        out.print(
            "<!DOCTYPE html>\n" +
            "<html>\n" +
            "    <head>\n" +
            "        <title>Start Page</title>\n" +
            "        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n" +
            "        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\" \n" +
            "              integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" crossorigin=\"anonymous\">\n" +
            "    </head>\n" +
            "    <body>\n" +
            "        <div class=\"container text-primary\" style=\"margin-top: 150px;\">\n" +
            "            <h1>OnlineStore – Gestion de la boutique.</h1>\n" +
            "<span class=\"text-success\"> Bonjour " + loginParam + " "+"<span><a class=\"text-dander\" href=\"logout\">(Deconnexion)</a></span>"+
                    
            "            <a class=\"nav-link active\"  href=\"catalogue.jsp\">Accès aux catalogues</a>\n"+
            "            <a class=\"nav-link\"  href=\"add-work-form.html\">Ajouter une œuvre au catalogue</a>\n"+
            "        </div>\n" +
                    
            "    </body>\n" +
            "</html>");
    }
            
 
}
