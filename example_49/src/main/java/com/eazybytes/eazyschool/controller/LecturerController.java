package com.eazybytes.eazyschool.controller;


import com.eazybytes.eazyschool.model.Courses;
import com.eazybytes.eazyschool.model.EazyClass;
import com.eazybytes.eazyschool.model.Person;
import com.eazybytes.eazyschool.repository.CoursesRepository;
import com.eazybytes.eazyschool.repository.EazyClassRepository;
import com.eazybytes.eazyschool.service.LecturerService;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import java.util.List;

@Slf4j
@Controller
@RequestMapping("lecturer")

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
 

