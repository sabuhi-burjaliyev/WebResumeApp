<%@page import="java.util.List"%>
<%@page import="inter.UserInterDao"%>
<%@page import="main.Context"%>
<%@page import="entity.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
UserInterDao userDao = Context.instanceUserDao();
String name = request.getParameter("name");
String surname = request.getParameter("surname");
String nationalityIdStr = request.getParameter("nid");
Integer nationalityId = null;
if(nationalityIdStr!=null && !nationalityIdStr.trim().isEmpty()){
    nationalityId = Integer.parseInt(nationalityIdStr);
}
List<User> users = userDao.getAll(name,surname,nationalityId);
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Users</title>
    </head>
    <body>
        <form action="users.jsp" method="POST">
            <input type="text" name="name" value=""/>
            <input type="text" name="surname" value=""/>
            <input type="submit" name="search" value="Search"/>
        </form>
        <div>
            <table>
                <thead>
                    <tr>
                        <th>Name</th>
                        <th>Surname</th>
                        <th>Nationality</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                    for(User u:users){
                    %>
                    <tr>
                        <td><%=u.getName()%></td>
                        <td><%=u.getSurname()%></td>
                        <td><%=u.getNationality_id().getCountry()==null?"N/A":u.getNationality_id().getCountry()%></td>
                    </tr>
                    <%}%>
                </tbody>
            </table>
            
        </div>
        
    </body>
</html>
