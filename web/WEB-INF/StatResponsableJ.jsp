<%-- 
    Document   : StatResponsableJ
    Created on : 22 janv. 2021, 12:51:29
    Author     : godart
--%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link type= "text/css" rel="stylesheet" href="${pageContext.request.contextPath}/style.css" />
        <script src = "https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.9.4/Chart.min.js"></script>
        <script src = "main.js"></script>
    </head>
    <body>
        <h1>Statistiques</h1>
        <div class="home">
            <div class="home-elem home-elem-left">
                <form action="${pageContext.request.contextPath}/ServletGraphResponsable" method="post" class="btn-group">
                    <button type ="submit" name ="buttonGraph" value="leGraphVisiteParSecteur" class="btn btn-first">leGraphVisiteParSecteur</button><br>
                    <button type ="submit" name ="buttonGraph" value="leGraphVisiteParSecteurParMois" class="btn btn-six">leGraphVisiteParSecteurParMois</button><br>
                    <button type ="submit" name ="buttonGraph" value="leGraphVisiteToutesLesAnnees" class="btn btn-second">leGraphVisiteToutesLesAnnées</button><br>
                    <button type ="submit" name ="buttonGraph" value="leGraphVisiteAnMois" class="btn btn-third">leGraphVisiteAnMois</button><br>
                    <button type ="submit" name ="buttonGraph" value="leGraphVisiteMoisAn" class="btn btn-four">leGraphVisiteMoisAn</button>
                    <!--<input type="select" name="Annee" class="btn btn-five">Entrez une année-->
                    <select name="Annee" >Quelles année voulez vous ?
                        <c:forEach var="uneAnnee" items="${listDate}">
                            <option valeur="${uneAnnee}">${uneAnnee}</option>
                        </c:forEach>
                    </select>
                </form>
            </div>
            <div class="home-elem home-elem-right">
                <canvas id="myGraph" height="400" width="1000"></canvas>
                <script>generGraph(${typeGraph},${LaList},${listSect},${listDate},${anneeRevolu});</script>    
            </div>           
        </div> 
    </body>
</html>