package com.charann.crudproject.api.controller;

import com.charann.crudproject.api.model.StudentModel;
import com.charann.crudproject.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class StudentController {

    @Autowired
    StudentRepository repo;

    // Get sll students
    @GetMapping("/students")
    public List<StudentModel> getAllStudents() {
        List<StudentModel> students = repo.findAll();
        return students;
    }

    @GetMapping("/students/{id}")
    public StudentModel getStudent(@PathVariable int id) {
        StudentModel student = repo.findById(id).get();
        return student;
    }

    @PostMapping("/student/add")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void createStudent(@RequestBody StudentModel student) {
        repo.save(student);
    }

    @PutMapping("/student/update/{id}")
    public StudentModel updateStudent(@PathVariable int id, @RequestBody StudentModel student) {
        StudentModel update_student = repo.findById(id).get();
        update_student.setName(student.getName());
        update_student.setCgpa(student.getCgpa());
        update_student.setDept(student.getDept());
        repo.save(update_student);
        return update_student;
    }

    @DeleteMapping("/student/delete/{id}")
    public void removeStudent(@PathVariable int id) {
        StudentModel student = repo.findById(id).get();
        repo.delete(student);
    }
}

