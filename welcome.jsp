<%-- 
    Document   : welcome.jsp
    Created on : May 18, 2023, 8:50:20 PM
    Author     : Nirmala
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>welcome  Page</title>
    </head>
    <body>
        Hello <strong><%= request.getParameter("username")%> </strong>,
        welcome<br>
        You Visited home page at <%=request.getParameter("visittime")%>
                
    </body>
</html>
