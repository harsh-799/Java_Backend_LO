<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Basic JSP Example</title>
</head>
<body>

    <h1> Name: ${user.name}</h1>
    <h1> Age: ${user.age}</h1>
    <h1> Course: ${user.course}</h1>
    <h1> Gender: ${user.gender}</h1>

    <h2>Go to Your ${user.course} course by clicking <a href="enrolledcourse">here</a></h2>


</body>
</html>