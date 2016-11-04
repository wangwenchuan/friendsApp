<%-- 
    Document   : add
    Created on : Oct 14, 2016, 11:09:29 PM
    Author     : Wenchuan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add A New Friend</title>
    </head>
    <body>
        <h1>Add A New Friend</h1>
        <form name="addForm" action="addFriend" method ="get">
            
            <label> Friend Name:</label>
            <input type="text" name="name" value=""/>
            <br>
            <label> Email Address:</label>
            <input type="text" name="email" value=""/>
            <br>
            <label> Age:</label>
            <input type="text" name="age" value=""/>
            <br>
            <label> Favorite Color:</label>
            <input type="text" name="color" value=""/>
            <br>
            <input type="submit" name="submit"   value="Submit" /> 
        </form>
        
    </body>
</html>
