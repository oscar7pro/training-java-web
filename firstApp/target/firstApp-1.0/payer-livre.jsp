<%-- 
    Document   : helloworld
    Created on : 26 sept. 2020, 12:00:42
    Author     : adonay
--%>

<%@page import="com.travauxpratiques.firstappcore.Personne"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>payer-livre</title>
         <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
    </head>
    <body>
        <div class="container">
            <p>Payement effectué avec le numero de carte :<%=request.getParameter("numeroCarte")%> </p>
            <ul class="list-group">Liste des livres payées
                <li class="list-group-item active">
                    <c:forEach items="${listeLivres}" var="livre">
                         <p>Le livre payé est le livre numero:  ${livre.numeroLivre}</p>
                    </c:forEach>
                </li>
            </ul>
           
        </div>
        </body>
</html>
