<%-- 
    Document   : add-work-form
    Created on : 26 sept. 2020, 13:34:47
    Author     : adonay
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <title>Ajouter une oeuvre au catalogue</title>
                <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    </head>
    <body>
          <div class="container" style="margin-top: 150px;">
            <form action="add-work" method="POST">
                <h1 class="bg-primary text-light">Ajouter une oeuvre au catalogue</h1>
                <div class="form-group">
                  <label for="title">Le titre</label>
                  <input type="text" class="form-control" id="title" name="title" placeholder="Enter le titre">
                </div>
                <div class="form-group">
                  <label for="release">Année de sortie</label>
                  <input type="text" class="form-control" id="release" name="release" placeholder="Enter l'année de sortie">
                </div>
                <div class="form-group">
                  <label for="genre">Le genre</label>
                  <input type="text" class="form-control" id="genre" name="genre" placeholder="Enter le genre">
                </div>
                <div class="form-group">
                  <label for="summary">Le resumé</label>
                  <input type="text" class="form-control" id="summary" name="summary" placeholder="Enter le resumé">
                </div>
                <div class="form-group">
                  <label for="mainArtist">L' artiste</label>
                  <input type="text" class="form-control" id="mainArtist" name="mainArtist" placeholder="Enter l'artiste">
                </div>
                <button type="submit" class="btn btn-primary">Ajouter</button>
            </form>
        </div>
    </body>
</html>
