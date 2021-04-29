<%-- 
    Document   : ConnexionJ
    Created on : 15 janv. 2021, 11:41:50
    Author     : randy
--%>

<link type= "text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css.css" />
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Connexion</title>
    </head>
        <body>
            <form method = "post" action ="${pageContext.request.getContextPath()}/ConnexionS">
            <centre>
                <div class="img-back">
                    <img src="images/log-back.png">
                </div>
                <div class="input-group">
                    <input type="text" name="login" class="input input-text">
                    <input type="password" name="mdp" class="input input-password">
                    <input type="submit" class="input input-valider" value="Valider">
                </div>
            </centre>
        </body>
</html>
