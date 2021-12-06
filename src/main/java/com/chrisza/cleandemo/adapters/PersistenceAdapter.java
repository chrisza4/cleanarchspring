package com.chrisza.cleandemo.adapters;

import com.chrisza.cleandemo.entities.Course;
import com.chrisza.cleandemo.entities.User;
import com.chrisza.cleandemo.persistence.repositories.CourseRepository;
import com.chrisza.cleandemo.persistence.repositories.UserRepository;


import org.springframework.stereotype.Component;

@Component
public class PersistenceAdapter {
    private CourseRepository courseRepository;
    private UserRepository userRepository;


    public PersistenceAdapter(CourseRepository courseRepository, UserRepository userRepository) {
        this.courseRepository = courseRepository;
        this.userRepository = userRepository;
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

    public User GetByUsername(String username) {
        throw new UnsupportedOperationException();
    }

    public User AddUser(User user) {
        this.userRepository.save(com.chrisza.cleandemo.persistence.entities.User.NewFromEntity(user));
        return user;
    }


}
