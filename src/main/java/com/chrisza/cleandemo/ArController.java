package com.chrisza.cleandemo;

import javax.xml.bind.ValidationException;

import com.chrisza.cleandemo.adapters.PersistenceAdapter;
import com.chrisza.cleandemo.entities.*;
import com.chrisza.cleandemo.usecases.CourseUseCases;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.test.context.support.WithAnonymousUser;
import org.springframework.web.bind.annotation.*;

@RestController
public class ArController {

    private PersistenceAdapter persistence;

    ArController(PersistenceAdapter persistenceAdapter) {
        this.persistence = persistenceAdapter;
    }

    @PostMapping("/")
    public User addCourse() {
        var user = new User("Chris");
        user.SetPassword("Hello");
        return this.persistence.AddUser(user);
    }
}