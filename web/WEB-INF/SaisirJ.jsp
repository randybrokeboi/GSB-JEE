<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
        <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/index.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.13/css/all.css" integrity="sha384-DNOHZ68U8hZfKXOrtjWvjxusGo9WQnrNx2sqG0tfsghAvtVlRW3tvkXWZh58N9jp" crossorigin="anonymous">

        <title>JSP Page</title>
    </head>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <link href="../../css/form.css" rel="stylesheet" type="text/css"/>
    <body>
        <h1>Saisissez votre rapport:</h1>
        	<div> 
		<form id="contact-page-form" method="post" action="${pageContext.request.getContextPath()}/SaisirS" >
                   
     	    <div class="controls controls-row">
            <div class="span12 col-md-12">
                <input class="form-control" name="${idVisiteur}" placeholder="* Votre nom (en tant que visiteur)" type="text" value="${NomVisiteur}" required="">
            </div>
        </div>
        <div class="controls controls-row">
            <div class="span12  col-md-12">
                <input class="form-control" name="date" placeholder="Date de la visite" type="text">
            </div>
            <div class="span12  col-md-12">
                <input class="form-control" name="motif" placeholder="* Motif de la Visite" type="text" value="" required="">
            </div>
        </div>
        <div class="controls">
            <div class="span12 col-md-12">
                <textarea name="bilan" class="form-control" rows="10" placeholder="* Bilan de la visite" required=""></textarea>
            </div>
        </div>
        <div class="controls controls-row">
            <div class="span12  col-md-12">
            
               <select name="idMedecin" >
                   <option value="">--Choisissez un médecin--</option>
                   <c:forEach var="med" items ="${listMedecins}">
                        <option value="${med.mId}">${med} </option>
                    </c:forEach>
                </select>
            </div>
        <div>
   
       
       

        <div class="controls span12 col-md-12">
            <button type="submit" class="btn btn-default hvr-bounce-to-right">Envoyer</button>
        </div>

        <p class="span12 col-md-12"><br>
            <small class="fa fa-asterisk required"></small> Informations requises
        </p>
            </form>
	</div>


        
    </body>
</html>
