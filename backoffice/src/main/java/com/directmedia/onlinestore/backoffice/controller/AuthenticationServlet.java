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
@WebServlet(name = "AuthenticationServlet", urlPatterns = {"/login"})
public class AuthenticationServlet extends HttpServlet {

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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        
         PrintWriter out = response.getWriter();
         response.setContentType("text/html");
          out.print("<html><head>"
                + "<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\" integrity=\"sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z\" crossorigin=\"anonymous\"></head>"
                + "<body><div class=\"container\">");
                
         if(login.equals("michel") && password.equals("123456") || login.equals("caroline") && password.equals("abcdef")){
              HttpSession session = request.getSession();
                session.setAttribute("login", login);
             
             out.print("<span>identification avec succes "+login+"</span><br/><a class=\"text-primary\"  href=\"home.jsp\">Retour à la page d'accueil </a>");
         } else{
             out.print("<span class=\"text-danger\">login / mdp erroné </span><br/><a class=\"text-primary\"  href=\"/backoffice/login.html\">Veuillez vous réidentifier en cliquant ici...</a>");
         }
         
          
         out.print("</div></body></html>");
    }

}
