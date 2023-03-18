package com.example.dao;


import com.example.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IStudentDAO extends JpaRepository<Student, Long> {
}
