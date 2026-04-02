<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Basic JSP Example</title>
</head>
<body>

    <p>
        Current time: <%= new java.util.Date() %>
    </p>

    <h1><%= System.getProperty("os.name") %></h1>

</body>
</html>