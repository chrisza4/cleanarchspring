package com.chrisza.cleandemo.usecases;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import javax.xml.bind.ValidationException;

import com.chrisza.cleandemo.adapters.PersistenceAdapter;
import com.chrisza.cleandemo.entities.Course;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class CourseUseCasesTests {
    @Mock
    private PersistenceAdapter mockPersistenceAdapter;

    @Test
    public void Sanity() {
        assertSame(1 + 1, 2);
    }

    @Test
    public void ShouldCreateNewCourse() {
        var useCase = new CourseUseCases(mockPersistenceAdapter);
        var course = new Course();
        course.name = "Hello";
        course.description = "World";
        try {
            useCase.AddCourse(course);
        } catch (ValidationException e) {
            fail();
        }
        verify(mockPersistenceAdapter, times(1)).AddCourse(course);
    }

    @Test
    public void ShouldNotCreateNewCourseIfNameEmpty() {
        var useCase = new CourseUseCases(mockPersistenceAdapter);
        var course = new Course();
        course.name = "";
        course.description = "World";
        assertThrows(ValidationException.class, () -> {
            useCase.AddCourse(course);
        });
        verify(mockPersistenceAdapter, times(0)).AddCourse(course);
    }
}
