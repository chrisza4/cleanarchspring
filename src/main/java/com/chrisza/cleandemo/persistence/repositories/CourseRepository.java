package com.chrisza.cleandemo.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.chrisza.cleandemo.persistence.entities.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {

}