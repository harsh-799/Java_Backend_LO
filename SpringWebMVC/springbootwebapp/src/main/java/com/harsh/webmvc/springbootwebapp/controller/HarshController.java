package com.harsh.webmvc.springbootwebapp.controller;


/* This file will basically replace the Sertvlets stuffs now in servlets we used to use extends Servlets
* But here to let tomcat know this is a Controller file which will take user request and process it.
* We'll use @Controller annotation with it.
*/

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.websocket.Session;
import org.springframework.boot.info.OsInfo;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HarshController {
    public HarshController() {
        System.out.println("Into the controller");
    }

    @RequestMapping("/details")
    public String getDetails() {
        return "details.jsp";
    }

    @RequestMapping("/addition")
    /*
    🔥 What @RequestMapping does
    👉 Means:

    “Handle request for /home (ANY HTTP method)”
    So it supports:

    GET
    POST
    PUT
    DELETE

    👉 All of them
     */
    public String getNumber(HttpServletRequest req, HttpSession session) {
        String num1 = req.getParameter("num1");
        String num2 = req.getParameter("num2");

        int n1 = Integer.parseInt(num1);
        int n2 = Integer.parseInt(num2);

        System.out.println(n1 + n2);

        int sum = n1 + n2;
        session.setAttribute("sum",sum); // Using session to get value across diff pages
        return "result.jsp"; // Note: We need to write .jsp over here
    }


}
