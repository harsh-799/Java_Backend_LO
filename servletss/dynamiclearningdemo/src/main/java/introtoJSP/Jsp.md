## ✅ Definition (for notes)

JSP is a technology used to create dynamic web pages using HTML + Java.

## 🧠 2️⃣ Real Concept (This is what makes it click)

👉 JSP is actually converted into a Servlet internally.

Yes, literally.

Flow:
```declarative
JSP file
   ↓
Converted to Servlet (by Tomcat)
   ↓
Compiled
   ↓
Executed
```

## 🔥 Example

Your JSP:
```HTML
<h1>Hello JSP</h1>
```
Tomcat internally converts it to something like:
```Java
out.println("<h1>Hello JSP</h1>");
```

## ⚙️ 3️⃣ Where JSP is Used

In web apps:

Servlet → handles logic  
JSP → handles UI (HTML)


## 🔥 5️⃣ JSP Elements (Core Things)

### 1. Scriptlet

```Java
<%
    String name = "Harsh";
    out.println(name);
%>
```
👉 Java code inside JSP

### 2. Expression

```java
<%= "Hello " + name %>
```
👉 Shortcut for printing

### 3. Declaration
```java
<%! int x = 10; %>
```
👉 Class-level variable / Instance variable


### 4. Importing Packages

```java
<%@ page import="java.util.Date" %>
```


### ⚠️ 6️⃣ Important Objects (Implicit Objects)

JSP gives some objects automatically:

| Object      | Use              |
| ----------- | ---------------- |
| request     | client request   |
| response    | response         |
| out         | print output     |
| session     | session handling |
| application | app-wide data    |


eg: We can directly do
```declarative
<%= request.getParameter("name") %>
```
You can see we haven't created Request from anywhere because it's implcitly created same with the others mentioned in table.

eg2: 
```declarative
<% out.println("<h1>Hii</h1>)
```
Now no where we have created the print writer object JSP internally creates it and gives us the out to use that and even better way is to use **<%= stuff to print**.