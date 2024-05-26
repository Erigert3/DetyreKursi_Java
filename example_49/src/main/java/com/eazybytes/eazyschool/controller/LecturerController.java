package com.eazybytes.eazyschool.controller;

<<<<<<< HEAD
import com.eazybytes.eazyschool.model.Courses;
import com.eazybytes.eazyschool.model.EazyClass;
import com.eazybytes.eazyschool.model.Person;
import com.eazybytes.eazyschool.repository.CoursesRepository;
import com.eazybytes.eazyschool.repository.EazyClassRepository;
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
    EazyClassRepository eazyClassRepository;

    @Autowired
    CoursesRepository coursesRepository;

    @GetMapping("/displayCourses")
    public ModelAndView displayCourses(Model model) {
        // List<Courses> courses = coursesRepository.findByOrderByNameDesc();
        List<Courses> courses = coursesRepository.findAll(Sort.by("name").descending());
        ModelAndView modelAndView = new ModelAndView("courses_secure.html");
        modelAndView.addObject("courses", courses);
        modelAndView.addObject("course", new Courses());
        return modelAndView;
    }

}
=======
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
 
>>>>>>> 41ad6718f127f8106610d0f782816f1ae59e9f33
