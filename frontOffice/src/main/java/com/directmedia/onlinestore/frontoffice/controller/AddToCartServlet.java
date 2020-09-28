/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.directmedia.onlinestore.frontoffice.controller;

import com.directmedia.onlinestore.officecore.entity.Catalogue;
import com.directmedia.onlinestore.officecore.entity.ShoppingCart;
import com.directmedia.onlinestore.officecore.entity.Work;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import sun.applet.AppletViewer;

/**
 *
 * @author adonay
 */
@WebServlet(name = "AddToCartServlet", urlPatterns = {"/addToCart"})
public class AddToCartServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                response.setContentType("text/html");
                response.setCharacterEncoding("UTF-8");
        String idAsString = request.getParameter("identifiant");
        Long idAsLong = Long.parseLong(idAsString);
        
        ShoppingCart cart = (ShoppingCart) request.getSession().getAttribute("cart");
        if(cart == null) {
            cart = new ShoppingCart();
            request.getSession().setAttribute("cart", cart);
        }
       /* 
       for(Work work : Catalogue.listOfWorks) {
            if(work.getId() == idAsLong) {
                cart.getItems().add(work);
            }
          }
       */
        final Optional<Work> optionalWork = Catalogue.listOfWorks.stream().filter(Work -> Work.getId()==idAsLong).findAny();
        if(optionalWork.isPresent()) {
            cart.getItems().add(optionalWork.get());   
        }
        PrintWriter out = response.getWriter();
        final int sizeCart = cart.getItems().size();
        out.print("<html><head>"
                + "<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\" integrity=\"sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z\" crossorigin=\"anonymous\"></head>"
                + "<body><div class=\"container\">");
        out.print("<p>Œuvre ajoutée au caddie ("+sizeCart+")</p>");
        out.print("<span class=\text-success\"><a href=\"catalogue\">Retour au catalogue</a></span>");

         out.print("</div></body></html>");
    }
}
