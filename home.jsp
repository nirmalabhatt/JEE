<%-- 
    Document   : home
    Created on : May 18, 2023, 8:37:45 PM
    Author     : Nirmala
--%>

<%@page import="java.util.*,java.text.*" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Home page</title>
    </head>
    <body>
        <%
            Date today= new Date();
            SimpleDateFormat sdf=new SimpleDateFormat("HH:mm:ss");
            String str=sdf.format(today);
            %>
      
        <form action="welcome.jsp" method="post">
            Enter your Name:<input type="text" name="username">
            <input type="hidden" name="visittime" value="<%= str %>">
            <br>
            
            <input type="submit" value="submit">
        </form>
    </body>
</html>
