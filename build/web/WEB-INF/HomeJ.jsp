
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% String info = (String) request.getAttribute("info"); %>
        <% String rep = (String) request.getAttribute("rep"); %>
        <h1>Bonjour<%=info%>, tes identifiants <%=rep%> dans notre base de donées</h1>
    </body>
</html>
