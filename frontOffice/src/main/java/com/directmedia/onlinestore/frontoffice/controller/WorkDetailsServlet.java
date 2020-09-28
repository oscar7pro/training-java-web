/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.directmedia.onlinestore.frontoffice.controller;

import com.directmedia.onlinestore.officecore.entity.Catalogue;
import com.directmedia.onlinestore.officecore.entity.Work;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
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
@WebServlet(name = "WorkDetailsServlet", urlPatterns = {"/work-details"})
public class WorkDetailsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html, charset=\"UTF-8\"");
       String id = request.getParameter("id");
       //PrintWriter out = response.getWriter();
       HttpSession session = request.getSession();
       
    //  Work work =  Catalogue.listOfWorks.stream().filter(w -> w.getId() == Long.parseLong(id)).findFirst().get();
        Work work = null;
       
        
        for(Work myWork : Catalogue.listOfWorks) {
            
       if(myWork.getId() == Long.parseLong(id)) {
           work = myWork;
           session.setAttribute("id", id);
         
           break;
       }
      }
        
        request.setAttribute("work", work);
        RequestDispatcher dispatcher  = request.getRequestDispatcher("/WEB-INF/work-details.jsp");
        dispatcher.forward(request, response);
        
        
    }

}
