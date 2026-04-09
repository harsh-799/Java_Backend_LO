package com.harsh.springboot.springdatajpa.repository;

import com.harsh.springboot.springdatajpa.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// 🌈 Here inside generics < , > we need to provide the Class whose Repo we wanna to make and type of the PK of that Entity.
@Repository
public interface StudentRepo extends JpaRepository<Student, Integer> {
}
