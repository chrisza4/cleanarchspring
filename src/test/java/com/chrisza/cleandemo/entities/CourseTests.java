package com.chrisza.cleandemo.entities;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class CourseTests {
    @Test
    public void IsValidShouldBeValidForNormalCourse() {
        var course = new Course();
        course.name = "MyCourse";
        course.description = "Super Course";

        var validationResult = course.Validate();
        assertTrue(validationResult.IsValid());
    }

    @Test
    public void IsValidShouldBeInvalidForEmptyCourseName() {
        var course = new Course();
        course.name = "";
        course.description = "Super Course";

        var validationResult = course.Validate();
        assertFalse(validationResult.IsValid());
        assertSame(validationResult.GetErrors().size(), 1);
        assertSame(validationResult.GetErrors().get(0), "Course name cannot be empty");
    }

    @Test
    public void IsValidShouldBeInvalidForBlankCourseName() {
        var course = new Course();
        course.name = "  ";
        course.description = "Super Course";

        var validationResult = course.Validate();
        assertFalse(validationResult.IsValid());
        assertSame(validationResult.GetErrors().size(), 1);
        assertSame(validationResult.GetErrors().get(0), "Course name cannot be empty");
    }

}
