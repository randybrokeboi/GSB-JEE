<%-- 
    Document   : HomeJ
    Created on : 15 janv. 2021, 11:42:05
    Author     : gueddoura
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/index.css">
        <title>Home</title>
    </head>
    <body>
        <center class="background">
            <img src="images/clipboard.png"  alt="image" class="center">
          
         

            <div class="groupe_boutton">
                <div id="menu">
                     <form method = "get" action ="${pageContext.request.getContextPath()}/SaisirS">
                        <input type="submit" class="champ consulter_text "  value="Saisir">
                        </form>
                     <form method = "get" action ="${pageContext.request.getContextPath()}/ModifierS">
                        <input type="submit" class="champ consulter_text " value="Modifier">
                        </form>
                     <form method = "get" action ="${pageContext.request.getContextPath()}/ConsulterS">
                        <input type="submit" class="champ consulter_text "  value="Consulter">
                        </form>
                     <form method = "get" action ="${pageContext.request.getContextPath()}/ServletGraphResponsable">
                        <input type="submit" class="champ consulter_text "  value="Statistiques">
                        </form>
                </div>
            </div>
        </center>
       
        
        

     
         
    </body>
</html>
