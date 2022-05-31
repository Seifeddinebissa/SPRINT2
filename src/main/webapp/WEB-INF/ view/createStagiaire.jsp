<%@ page language="java" contentType="text/html; charset=windows-1256" pageEncoding="windows-1256" %>
    <!DOCTYPE html>
    <html>

    <head>
        <meta charset="windows-1256">
        <title>Créer un stagiaire</title>
    </head>

    <body>
        <form action="saveStagiaire" method="post">
            <pre>
nom : <input type="text" name="nom">
prenom : <input type="text" name="prenom">
cin : <input type="text" name="cin">
societe : <input type="text" name="societe">
date debut : <input type="date" name="date1">
date fin : <input type="date" name="date2">
<input type="submit" value="ajouter">
</pre>
        </form>
        ${msg}
        <br />
        <br />
        <a href="ListeProduits">Liste Produits</a>
    </body>

    </html>