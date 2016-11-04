

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    
    <% String table = (String) request.getAttribute("table");%>
    
    
    <body>
        <h1>Wenchuan's Friends</h1>
        
        <%= table %>
        
        <br>
        <br>
        <br>
        <a href="add"> Add a New Friend</a>
        <br>
        <a href="search.jsp">Search Friends</a>
    </body>
</html>
