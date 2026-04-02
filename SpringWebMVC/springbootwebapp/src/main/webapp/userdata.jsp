<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Basic JSP Example</title>
</head>
<body>

<h1> Name is: <%= session.getAttribute("name")%></h1>
<h1> Age is: <%= session.getAttribute("age")%></h1>
<h1> City is: <%= session.getAttribute("city")%></h1>
<h1> Gender: <%= session.getAttribute("gendLing")%></h1>

</body>
</html>