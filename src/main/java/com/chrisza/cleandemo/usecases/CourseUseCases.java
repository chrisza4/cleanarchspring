package com.chrisza.cleandemo.usecases;

import javax.xml.bind.ValidationException;

import com.chrisza.cleandemo.adapters.PersistenceAdapter;
import com.chrisza.cleandemo.entities.Course;

import org.springframework.stereotype.Component;

@Component
public class CourseUseCases {
    private PersistenceAdapter persistenceAdapter;

    public CourseUseCases(PersistenceAdapter persistenceAdapter) {
        this.persistenceAdapter = persistenceAdapter;
    }

    public Course AddCourse(Course data) throws ValidationException {
        if (data.name.isBlank()) {
            throw new ValidationException("Name must not be empty");
        }
        return this.persistenceAdapter.AddCourse(data);
    }
}
