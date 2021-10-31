package com.chrisza.cleandemo;

import com.chrisza.cleandemo.adapters.PersistenceAdapter;
import com.chrisza.cleandemo.entities.*;
import com.chrisza.cleandemo.persistence.repositories.*;
import com.chrisza.cleandemo.usecases.CourseUseCases;

import org.springframework.web.bind.annotation.*;

@RestController
public class CourseController {

    private CourseUseCases courseUseCases;

    CourseController(CourseUseCases courseUseCases) {
        this.courseUseCases = courseUseCases;
    }

    @PostMapping("/course")
    public Course addCourse(@RequestBody Course data) {
        return this.courseUseCases.AddCourse(data);
    }

}