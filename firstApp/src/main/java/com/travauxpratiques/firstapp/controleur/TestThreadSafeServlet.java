/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.travauxpratiques.firstapp.controleur;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author adonay
 */
@WebServlet(name = "TestThreadSafeServlet", urlPatterns = {"/testThread"})
public class TestThreadSafeServlet extends HttpServlet {


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
        String montant = request.getParameter("montant");
        try{
            Thread.sleep(10000);
        }catch(InterruptedException e) {
            Logger.getLogger(TestThreadSafeServlet.class.getName()).log(Level.SEVERE, null,e);
        }
        PrintWriter out = response.getWriter();
         out.print("<html><head>"
                + "<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\" integrity=\"sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z\" crossorigin=\"anonymous\"></head>"
                + "<body><div class=\"container\"><h1 class=\"list-group-item list-group-item-action active \">"+montant+"</h1><br/>");
             
         out.print("</div></body></html>");
    }

}
