package com.chrisza.cleandemo.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.chrisza.cleandemo.persistence.entities.User;

import javax.persistence.Table;

@Table(name = "\"user\"")
public interface UserRepository extends JpaRepository<User, Long> {

}