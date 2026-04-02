<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Basic JSP Example</title>
</head>
<body>

<!--
🧠 What is ${}?

👉 Expression Language (EL)

Spring automatically:

Model → JSP variables
-->

<h1> Name is: ${name} </h1>
<h1> Age is: ${age} </h1>
<h1> City is: ${city} </h1>
<h1> Gender: ${gender} </h1>

<!--
🚨 Problem in your code
<%= ${name} %> ❌
👉 You are mixing:

<%= %> → JSP scriptlet (old Java way)
${} → Expression Language (EL)

👉 These cannot be used together

🧠 Why this is wrong
Syntax	Meaning
<%= %>	Java expression
${}	EL (recommen

-->

</body>
</html>