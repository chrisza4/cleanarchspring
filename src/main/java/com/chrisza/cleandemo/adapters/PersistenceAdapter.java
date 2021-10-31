package com.chrisza.cleandemo.adapters;

import com.chrisza.cleandemo.entities.Course;
import com.chrisza.cleandemo.persistence.repositories.CourseRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PersistenceAdapter {
    private CourseRepository courseRepository;

    public PersistenceAdapter(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public Course AddCourse(Course course) {
        var coursePersistenceEntity = new com.chrisza.cleandemo.persistence.entities.Course(course.name,
                course.description);
        var courseResult = courseRepository.save(coursePersistenceEntity);
        var result = new Course();
        result.name = courseResult.getName();
        result.description = courseResult.getDescription();
        return result;
    }
}
