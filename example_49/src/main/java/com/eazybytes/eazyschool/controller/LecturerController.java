package com.eazybytes.eazyschool.controller;

import com.eazybytes.eazyschool.service.LecturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.eazybytes.eazyschool.model.Person;

import jakarta.servlet.http.HttpSession;

@Controller
public class LecturerController {

    @Autowired
    private LecturerService lecturerService;


    @GetMapping("/displayCourses")
    public ModelAndView displayCourses(HttpSession session) {
        Person person = (Person) session.getAttribute("loggedInPerson");
        ModelAndView modelAndView = new ModelAndView("lecturer_courses.html");
        modelAndView.addObject("person", person);
        modelAndView.addObject("courses", person.getCourses()); // Assuming getCourses() returns the courses taught by the lecturer
        return modelAndView;
    }


}
 