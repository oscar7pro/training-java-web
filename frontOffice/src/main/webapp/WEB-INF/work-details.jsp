<%-- 
    Document   : work-details
    Created on : 26 sept. 2020, 17:47:50
    Author     : adonay
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Catalogue</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
    </head>
    <body>
        <div class="container">
            <h1 class="list-group-item list-group-item-action active">Detail de l'oeuvre</h1>
            <ul class="list-group">
                <li class="list-group-item"> ${ work.title }</li>
                <li class="list-group-item"> ${work.genre }</li>
                <li class="list-group-item"> ${work.summary}</li> 
                <li class="list-group-item"> ${work.mainArtist.name}</li>
                <li class="list-group-item"> ${work.release}</li>
            </ul>
            <hr>
             <form action="addToCart" method="POST">
            <div>
                <input type="hidden"  id="identifiant" name="identifiant" value="${work.id}"/>
            </div>
           <button type="submit" class="btn btn-danger">Ajouter au caddie</button>
       </form>
        </div>
    </body>
</html>
