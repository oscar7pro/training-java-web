 
$(document).ready(function(){
    $('input').last().on('click',function(){
            $.ajax({
              url: "rest/calculation/somme-et-produit",
              data: $("form").serialize(),
              success: function(resultObject) {
                 var message = "<p class=\"container text-primary\">La somme de 2 nombre fournie est : "+resultObject.somme.numerique+" - "+resultObject.somme.texte+"</p>";
                 message=message.concat("<p class=\"container text-primary\">La somme de 2 nombre fournie est : "+resultObject.produit.numerique+" - "+resultObject.produit.texte+"</p>");
                 
                  $("form").after(message);
              }
            });
        
    });
});