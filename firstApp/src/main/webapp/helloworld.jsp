<%-- 
    Document   : helloworld
    Created on : 26 sept. 2020, 12:00:42
    Author     : adonay
--%>

<%@page import="com.travauxpratiques.firstappcore.Personne"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
         <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
    </head>
    <body>
        <div class="container">
        <h1>Hello World!</h1>
            <%
                int nombre = 99;
                Personne michelDupont = new Personne("Dupont", "Michel");
                if(nombre == 99){
                    
            %>
            <span>Ce text est affiché si nombre vaut <%= nombre %></span>
            <% }
            %>
            <p>Bonjour <%=  michelDupont.getFullName() %></p>
        </div>
        </body>
</html>
