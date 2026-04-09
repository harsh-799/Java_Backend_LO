package com.harsh.springboot.springdatajpa.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Entity
@Scope(scopeName = "prototype")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int studentId;
    String studentName;
    String studentEmail;
    long studentMobileNumber;

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }

    public long getStudentMobileNumber() {
        return studentMobileNumber;
    }

    public void setStudentMobileNumber(long studentMobileNumber) {
        this.studentMobileNumber = studentMobileNumber;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                ", studentEmail='" + studentEmail + '\'' +
                ", studentMobileNumber=" + studentMobileNumber +
                '}';
    }
}
