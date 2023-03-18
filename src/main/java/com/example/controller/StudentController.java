package com.example.controller;

import com.example.dto.StudentDTO;
import com.example.model.Student;
import com.example.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("student")
public class StudentController {

    @Autowired
    IStudentService studentService;

    @PostMapping("/add")
    public StudentDTO add(@RequestBody StudentDTO student) {
        System.out.println(student);
        return studentService.add(student);
    }

    @GetMapping("/getAll")
    public List<StudentDTO> getAll() {
        return studentService.getAll();
    }

    @PutMapping("/update")
    public StudentDTO updateStudent(@RequestBody StudentDTO student) {
        return studentService.updateStudent(student);
    }

    @DeleteMapping("/delete/{studId}")
    public String deleteById(@PathVariable long studId) {
        return studentService.deleteById(studId);
    }
}
