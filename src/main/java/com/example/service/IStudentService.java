package com.example.service;

import com.example.dto.StudentDTO;

import java.util.List;

public interface IStudentService {

    public StudentDTO add(StudentDTO student);
    public List<StudentDTO> getAll();
    public StudentDTO updateStudent(StudentDTO student);
    public String deleteById(long studId);
}
