package com.telusko.springJDBCExmple.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.telusko.springJDBCExmple.model.Student;

@Repository
public class StudentRepo {

    private JdbcTemplate jdbc;

    

    public void save(Student s) {
        String sql = "INSERT INTO student (rollno, name, marks) VALUES (?, ?, ?)";
        int rows =jdbc.update(sql, s.getRollNum(), s.getName(), s.getMarks());
        System.out.println("Rows affected: " + rows);
    }

    public List<Student> findAll() {
        String sql = "Select * from student";
        return jdbc.query(sql, (rs, rowNum)->{
            Student s = new Student();
            s.setRollNum(rs.getInt("rollno"));
            s.setName(rs.getString("name"));
            s.setMarks(rs.getInt("marks"));
            return s;
        });
    }

    public JdbcTemplate getJdbc() {
        return jdbc;
    }

    @Autowired
    public void setJdbc(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }
}
