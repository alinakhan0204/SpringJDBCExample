package com.telusko.springJDBCExmple.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.telusko.springJDBCExmple.model.Student;
import com.telusko.springJDBCExmple.repository.StudentRepo;

@Service
@Scope("prototype")
public class StudentService {

    @Autowired
    private StudentRepo studentRepo;

    public void addStudent(Student s) {
        studentRepo.save(s);

    }

    public StudentRepo getStudentRepo() {
        return studentRepo;
    }

    public void setStudentRepo(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    public List<Student> getStudents() {
        return studentRepo.findAll();
    }

}
