package com.chrisza.cleandemo.usecases;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import com.chrisza.cleandemo.adapters.PersistenceAdapter;
import com.chrisza.cleandemo.entities.Course;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

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
        Mockito.when(mockPersistenceAdapter.AddCourse(course)).thenReturn(new Course() {

        });
        course.name = "Hello";
        course.description = "World";
        useCase.AddCourse(course);
        verify(mockPersistenceAdapter, times(1)).AddCourse(course);
    }
}
