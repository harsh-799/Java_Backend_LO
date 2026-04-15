package com.spring.security.basics.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class AllLabourResponse {
    private int labourId;
    private String labourName;
    private int salary;
    private int age;

    public int getLabourId() {
        return labourId;
    }

    public void setLabourId(int labourId) {
        this.labourId = labourId;
    }

    public String getLabourName() {
        return labourName;
    }

    public void setLabourName(String labourName) {
        this.labourName = labourName;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
