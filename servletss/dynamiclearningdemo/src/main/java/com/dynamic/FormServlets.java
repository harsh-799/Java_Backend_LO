package com.dynamic;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/submitForm")
public class FormServlets extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String city = req.getParameter("city");
        String ageStr = req.getParameter("age"); // ⚠️ Even though age is number in Html use getParamter() everything is converted to string.

        Integer age = Integer.parseInt(ageStr);

        PrintWriter writer = resp.getWriter();

        // Normal printing on Screen
        // if (age >= 18){
        //     writer.println("Your name is "+name);
        //     writer.println("Your age is" + age);
        //     writer.println(" You're from "+city);
        //     writer.println("Congrats You're allowed inside to webpage");
        // } else {
        //     writer.println("Bada hoo ja pahele");
        // }

        // Instead, we can also send resp using HTML format
        if (age >= 18){
            writer.println("<h1> Your name is "+name+"</h1>");
            writer.println("<h1> Your age is" + age+ "</h1>");
            writer.println("<h1> You're from "+city+ "</h1>");
            writer.println("<h1> Congrats You're allowed inside to webpage ✅ </h1>");
        } else {
            writer.println("<h1 style='color: red'>Bada hoo ja pahele</h1>");
        }


    }
}
