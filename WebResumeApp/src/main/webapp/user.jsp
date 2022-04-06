<%-- 
    Document   : user
    Created on : Apr 2, 2022, 9:56:38 PM
    Author     : Plague
--%>

<%@page import="main.Context"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="entity.User"%>
<%@page import="inter.UserInterDao"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User JSP Page</title>
    </head>
    <body>
        <%
            UserInterDao userDao = Context.instanceUserDao();
            User u = userDao.getUserById(1);
        %>
        <form action="ShoppingPage" method="POST">
            <label>Name</label> 
            <input type="text" name="name" value="<%=u.getName()%>"/>
            <br/>
            <label>Surname</label> 
            <input type="text" name="surname" value="<%=u.getSurname()%>"/>
            <br/>
            <input type="submit" name="ok" value="OK"/>
        </form>

    </body>
</html>
