package com.chrisza.cleandemo;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.*;
import org.springframework.security.config.annotation.authentication.builders.*;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.*;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .authorizeRequests(authorize ->
//                         authorize.anyRequest().authenticated()
//                                 .anyRequest().permitAll();
//                        authorize.anyRequest().permitAll()
//                );
//                .formLogin(withDefaults())
//                .httpBasic(withDefaults());
        http.csrf().disable().authorizeRequests().anyRequest().permitAll();
    }}