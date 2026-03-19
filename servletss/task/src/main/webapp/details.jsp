<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>My JSP Page</title>
</head>
<body>

   <h1>Your details are: </h1>

   <h3> Name: <%= request.getAttribute("name") %>
   <h3> Age: <%= request.getAttribute("age") %>
   <h3> City: <%= request.getAttribute("city") %>
   <h3> Skills: <%= request.getAttribute("skills") %>

</body>
</html>