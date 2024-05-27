package com.charann.crudproject.api.model;

import jakarta.persistence.*;

@Entity
@Table
public class StudentModel {
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
   @Column
    private String name;
   @Column
    private String dept;
   @Column
    private double cgpa;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public double getCgpa() {
        return cgpa;
    }

    public void setCgpa(double cgpa) {
        this.cgpa = cgpa;
    }

    public StudentModel(String name, String dept, double cgpa) {
        this.name = name;
        this.dept = dept;
        this.cgpa = cgpa;
    }

    public StudentModel() {
    }

    @Override
    public String toString() {
        return "StudentModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dept='" + dept + '\'' +
                ", cgpa=" + cgpa +
                '}';
    }
}
