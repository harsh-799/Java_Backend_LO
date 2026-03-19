<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>JSP Task</title>
</head>
<body>
<%
    String name = (String) request.getAttribute("name");
    Integer age = (Integer) request.getAttribute("age");
    String gender = (String) request.getAttribute("gender");
    Boolean status = (Boolean) request.getAttribute("status");
%>
<%
if (status != null && status) {
%>
<h1> Your name is: <%= name %>
<h1> Your Age is: <%= age %>
<h1> Your gender is: <%= gender %>
<h1>You are adult</h1>
<%
} else {
%>
<h1> Laika ho babu </h1>
<%
}
%>

</body>
</html>
