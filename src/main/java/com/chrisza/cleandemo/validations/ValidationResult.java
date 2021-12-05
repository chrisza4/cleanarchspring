package com.chrisza.cleandemo.validations;

import java.util.*;

public class ValidationResult {
    private List<String> Errors;

    public List<String> GetErrors() {
        return this.Errors;
    }

    public Boolean IsValid() {
        return this.Errors.size() == 0;
    }

    public ValidationResult() {
        this(null);
    }

    public ValidationResult(List<String> errors) {
        if (errors == null) {
            errors = new ArrayList<String>();
        }
        this.Errors = errors;
    }
}