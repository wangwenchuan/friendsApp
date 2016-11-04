

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Friends"%>
<%Friends friend=(Friends) request.getAttribute("friend");%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update a friend</title>
    </head>
    <body>
        <h1>Update a friend Record</h1>
        <form name="updateForm" action="updateFriend" method ="get">
            
            
            <label> Friend ID:</label>
            <input type="text" name="id" value="<%=friend.getFriendID() %>" readonly/>
            <br>
            <label> Friend Name:</label>
            <input type="text" name="name" value="<%=friend.getFriendName() %>"/>
            <br>
            <label> Email Address:</label>
            <input type="text" name="email" value="<%=friend.getEmailAddr() %>"/>
            <br>
            <label> Age:</label>
            <input type="text" name="age" value="<%=friend.getAge() %>"/>
            <br>
            <label> Favorite Color:</label>
            <input type="text" name="color" value="<%=friend.getFavoriteColor() %>"/>
            <br>
            <input type="reset" name="clear"   value="Clear" /> 
            <input type="submit" name="submit"   value="Update" /> 
        </form>
    </body>
</html>
