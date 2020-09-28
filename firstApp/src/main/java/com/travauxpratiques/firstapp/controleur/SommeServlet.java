/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.travauxpratiques.firstapp.controleur;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.travauxpratiques.firstappcore.Produit;
import com.travauxpratiques.firstappcore.Somme;
import com.travauxpratiques.firstappcore.SommeEtProduit;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sun.rmi.server.Dispatcher;


/**
 *
 * @author adonay
 */
@WebServlet(name = "SommeServlet", urlPatterns = {"/somme"})
public class SommeServlet extends HttpServlet {
/*
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        String nombre1 = request.getParameter("nombre1");
        String nombre2 = request.getParameter("nombre2");
        try {
        int sommeNumerique = Integer.parseInt(nombre1) + Integer.parseInt(nombre2);
        int produitNumerique = Integer.parseInt(nombre1) * Integer.parseInt(nombre2);
        
        String format = request.getParameter("format");
         //request.setAttribute("somme", somme);
        if(format != null && format.equals("pdf")) {
           request.setAttribute("somme", sommeNumerique);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/pdf");
            dispatcher.forward(request, response);
            
        }else{
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/affichage-somme.jsp");
            dispatcher.forward(request, response);
          }
  
    } catch(NumberFormatException numberFormatException) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/unexpected-error.html");
    }
    }
  */  
     @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String nombre1 = request.getParameter("nombre1");
        String nombre2 = request.getParameter("nombre2");
        
       
        try {
             int sommeNumerique = Integer.parseInt(nombre1) + Integer.parseInt(nombre2);
            int produitNumerique = Integer.parseInt(nombre1) * Integer.parseInt(nombre2);
           String format = request.getParameter("format");
           
           if(format != null && format.equals("pdf")) {
                request.setAttribute("somme", sommeNumerique);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/pdf");
                dispatcher.forward(request, response);
            
           
        }else{
                
            }
    } catch(NumberFormatException numberFormatException) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/unexpected-error.html");
    }
    }
    
    
    

}
