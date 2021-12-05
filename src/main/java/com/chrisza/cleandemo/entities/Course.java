package com.chrisza.cleandemo.entities;

import java.util.ArrayList;

import com.chrisza.cleandemo.validations.ValidationResult;

public class Course {
    public String name;
    public String description;

    public ValidationResult Validate() {
        var errors = new ArrayList<String>();
        if (this.name.isBlank()) {
            errors.add("Course name cannot be empty");
        }
        return new ValidationResult(errors);
    }
}
