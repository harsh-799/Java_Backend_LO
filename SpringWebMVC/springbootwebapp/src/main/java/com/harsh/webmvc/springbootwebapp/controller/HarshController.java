package com.harsh.webmvc.springbootwebapp.controller;


/* This file will basically replace the Sertvlets stuffs now in servlets we used to use extends Servlets
* But here to let tomcat know this is a Controller file which will take user request and process it.
* We'll use @Controller annotation with it.
*/

import org.springframework.boot.info.OsInfo;
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


}
