package com.eazybytes.eazyschool.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.*;

import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
public class Courses extends BaseEntity{



    @Id
    @GeneratedValue(strategy= GenerationType.AUTO,generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    private int courseId;

    private String name;

    private String fees;

    @ManyToMany(mappedBy = "courses", fetch = FetchType.EAGER,cascade = CascadeType.PERSIST)
    private Set<Person> persons = new HashSet<>();
<<<<<<< HEAD
    
    private Person lecturer;
=======

    public List<Person> getLecturers() {

    }
>>>>>>> 41ad6718f127f8106610d0f782816f1ae59e9f33
}
