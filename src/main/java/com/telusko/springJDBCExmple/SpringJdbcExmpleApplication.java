package com.telusko.springJDBCExmple;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.telusko.springJDBCExmple.model.Student;
import com.telusko.springJDBCExmple.service.StudentService;

@SpringBootApplication
public class SpringJdbcExmpleApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(SpringJdbcExmpleApplication.class, args);

		Student s = ctx.getBean(Student.class);
		s.setRollNum(4);
		s.setName("John");
		s.setMarks(85);

		StudentService ss = ctx.getBean(StudentService.class);
		ss.addStudent(s);

		List<Student> students = ss.getStudents();
		System.out.println("All students: " + students);
	}

}
