/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.directmedia.onlinestore.backoffice.controller;

import com.directmedia.onlinestore.officecore.entity.Artist;
import com.directmedia.onlinestore.officecore.entity.Catalogue;
import com.directmedia.onlinestore.officecore.entity.Work;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author adonay
 */
@WebServlet(name = "AddWorkServlet", urlPatterns = {"/add-work"})
public class AddWorkServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
         boolean success = true;
        String title = request.getParameter("title");
        String release = request.getParameter("release");
        String genre = request.getParameter("genre");
        String summary = request.getParameter("summary");
        String mainArtist = request.getParameter("mainArtist");
        
        
        Work work = new Work(title);
        Artist artist = new Artist(mainArtist);
       
        try {
        
        work.setRelease(Integer.parseInt(release));
        
        }catch(NumberFormatException exception) {
            success = false;
        }
        work.setGenre(genre);
        work.setSummary(summary);
        work.setMainArtist(artist);
        
       /* 
        for(Work w : Catalogue.listOfWorks) {
            if(w.getTitle() == work.getTitle() && w.getRelease() == work.getRelease() && w.getMainArtist().getName() == work.getMainArtist().getName()) {
                success = false;
            }
        }
        */
        RequestDispatcher dispatcher = null;
        
       Optional<Work> optionalWork =  Catalogue.listOfWorks.stream().filter(w -> w.getTitle() == work.getTitle() && w.getRelease() == work.getRelease()
        && w.getMainArtist().getName() == work.getMainArtist().getName()).findAny();
     
       if(optionalWork.isPresent()) {
           success = false;
       }
        
        if(success == true) {
            request.setAttribute("identifiantOuevre", work.getId());
        Catalogue.listOfWorks.add(work);
         dispatcher = request.getRequestDispatcher("/work-added-success");
        } else {
             dispatcher = request.getRequestDispatcher("/work-added-faillure");
        }
        
        dispatcher.forward(request, response);
      }

}
