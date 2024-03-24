<html>
<head>
<title>My Counter JSP</title>
</head>
<body>
<%!
int count;
%>
<h3>This page has been accessed <%= ++count %> times</h3>
</body>
</html>