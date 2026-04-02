<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Basic JSP Example</title>
</head>
<body>

<!-- Dont think from where session is coming i hope you remember that in servlet we studied that jsp provides some default objects
session,request,response,out, etc.. -->
   <h1>Result is: <%= session.getAttribute("sum") %> </h1>

</body>
</html>