package com.chrisza.cleandemo.entities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserTests {
    @Test
    public void CanSetAndValidatePassword() {
        var user = new User("chris");
        user.SetPassword("MyPassword1");
        assertTrue(user.ValidatePassword("MyPassword1"));
        assertFalse(user.ValidatePassword("MMM"));
        assertNotEquals("MyPassword1", user.GetHashedPassword());
    }
}
