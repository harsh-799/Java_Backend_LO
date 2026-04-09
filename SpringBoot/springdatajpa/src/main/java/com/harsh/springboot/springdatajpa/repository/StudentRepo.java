package com.harsh.springboot.springdatajpa.repository;

import com.harsh.springboot.springdatajpa.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

// 🌈 Here inside generics < , > we need to provide the Class whose Repo we wanna to make and type of the PK of that Entity.
@Repository
public interface StudentRepo extends JpaRepository<Student, Integer> {

    public Optional<Student> findByStudentMobileNumber(long studentMobileNumber); // 🌱 Even we're not delcaring it's working Spring will automatcially do so without we need to expictly define it.


    @Query("SELECT s FROM Student s WHERE s.studentName = :name AND s.studentEmail = :email")
    public Optional<Student> findByNaamAndEmailQueryEdition(@Param("name") String naam, @Param("email") String email);
}
