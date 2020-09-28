/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.travauxpratiques.firstapp.controleur;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
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
@WebServlet(name = "PdfServlet", urlPatterns = {"/pdf"})
public class PdfServlet extends HttpServlet {


  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/pdf");
        try {
            Document document = new Document();
            PdfWriter.getInstance(document, response.getOutputStream());
            
            document.open();
            Integer somme =(Integer) request.getAttribute("somme");
            String message = null;
            if(somme != null) {
                message = "La somme des deux nombres fournie est :" +somme;
            }else{
                message = "hello world!";
            }
            document.add(new Paragraph(message));
            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
      
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/pdf");
        try {
            Document document = new Document();
            PdfWriter.getInstance(document, response.getOutputStream());
            
            document.open();
            //request.getAttribute("somme");
            Integer somme =(Integer) request.getAttribute("somme");
            String message = null;
            if(somme != null) {
                message = "La somme des deux nombres fournie est :" +somme;
            }else{
                message = "hello world!";
            }
            document.add(new Paragraph(message));
            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

 

}
