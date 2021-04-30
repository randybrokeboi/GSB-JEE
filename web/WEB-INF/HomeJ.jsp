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
                     <p class="champ saisir_text"><a href="<c:url value="/SaisirS"/>">Saisir</a></p>
                     <p class="champ modifier_text"><a href="<c:url value="/ModifierS"/>">Modifier</a></p>
                     <p class="champ consulter_text"><a href="<c:url value="/ConsulterS"/>">Consulter</a></p>
                </div>
            </div>
        </center>
       
        
        

     
         
    </body>
</html>
