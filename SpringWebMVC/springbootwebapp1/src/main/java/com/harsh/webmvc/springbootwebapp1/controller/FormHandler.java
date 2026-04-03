package com.harsh.webmvc.springbootwebapp1.controller;

import com.harsh.webmvc.springbootwebapp1.model.User;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FormHandler {

    public FormHandler() {
        System.out.println("Into controller");
    }

    @PostMapping("/register")
    public ModelAndView getData(@ModelAttribute User user, ModelAndView mv, HttpSession session) {
        session.setAttribute("user", user);
        mv.setViewName("success");

        return mv;
    }

    @GetMapping("/enrolledcourse")
    public ModelAndView showCourse(HttpSession session, ModelAndView mv) {
        User user = (User) session.getAttribute("user");
        mv.addObject(user);
        mv.setViewName("course");

        return mv;
    }
}
