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
import org.springframework.web.bind.annotation.RequestParam;

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

    /* Now we'll be using Spring MVC stuffs instead of using Servlets */

    /* Now using that servlets is old fashion and we use Spring mvc concept here, but we'll not be jumping to major concept at once we'll do in step by step.
    * Step by step we'll be replacing Servlets and all stuffs with Spring MVC,
    */

    // Now instead of doing req.getParameter(nameFromForm) we're using automatic mapping in which the spring will manage stuffs it'll be directing assigning the data from form to these properties.
    // ⚠️ Note: The name="" in the form and here the property must be in same written format.
    // 🌟 Now if someone want to use diff name instead of name="" from form, so they can use @RequestParam("nameValueOfForm") here you must write name value and after that whatever you like you can write that.
    @RequestMapping("/submitdata")
    public String showUserData(String name, int age, String city, @RequestParam("gender") String ling, HttpSession session) {

        session.setAttribute("name",name);
        session.setAttribute("age",age);
        session.setAttribute("city",city);
        session.setAttribute("gendLing",ling);

        /*  📢 In the next part we gonna get rid of this manually setting the attribute too.*/

        return "userdata.jsp";
    }


}
