package com.example.service;

import com.example.dao.IStudentDAO;
import com.example.dto.StudentDTO;
import com.example.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class StudentServiceImpl implements IStudentService {
    @Autowired
    IStudentDAO iStudentDAO;


    public List<StudentDTO> getAll() {
        List<Student> studentM = iStudentDAO.findAll();
        System.out.println("successfully got the data" + studentM);
        List<StudentDTO> sDtoL = convertStudentListToStudentDTO(studentM);
        System.out.println(sDtoL);
        return sDtoL;
    }

    public List<StudentDTO> convertStudentListToStudentDTO(List<Student> studentM) {
        Iterator<Student> stud2 = studentM.iterator();//understand
        List<StudentDTO> studentDto2 = new ArrayList<>();
        while (stud2.hasNext()) {
            Student s2 = stud2.next();
            StudentDTO sDto2 = new StudentDTO();
            sDto2.setStudentId(s2.getStudentId());
            sDto2.setStudentAge(s2.getStudentAge());
            sDto2.setStudentName(s2.getStudentName());
            sDto2.setCity(s2.getCity());
            sDto2.setMobileNumber(s2.getMobileNumber());
            studentDto2.add(sDto2);
        }
        return studentDto2;
    }


    public StudentDTO add(StudentDTO sDto3) {
        Student stu = convertStudentDTOToStudent(sDto3);
        Student savedS = iStudentDAO.save(stu);
        System.out.println("Successfully added : " + savedS);
        return convertStudentToStudentDTO(savedS);
    }

    public Student convertStudentDTOToStudent(StudentDTO sd3) {
        Student sm3 = new Student();
        sm3.setStudentName(sd3.getStudentName());
        sm3.setStudentAge(sd3.getStudentAge());
        sm3.setCity(sd3.getCity());
        sm3.setMobileNumber(sd3.getMobileNumber());
        return sm3;
    }

    public StudentDTO convertStudentToStudentDTO(Student sStudent3) {
        StudentDTO sDto = new StudentDTO();
        sDto.setStudentId(sStudent3.getStudentId());
        sDto.setStudentName(sStudent3.getStudentName());
        sDto.setStudentAge(sStudent3.getStudentAge());
        sDto.setCity(sStudent3.getCity());
        sDto.setMobileNumber(sStudent3.getMobileNumber());
        return sDto;
    }


    public StudentDTO updateStudent(StudentDTO student) {
        long studId = student.getStudentId();
        Student stud = iStudentDAO.findById(studId).get();
        stud.setStudentId(student.getStudentId());
        stud.setStudentAge(student.getStudentAge());
        stud.setStudentName(student.getStudentName());
        stud.setCity(student.getCity());
        stud.setMobileNumber(student.getMobileNumber());
        Student studUpdated = iStudentDAO.save(stud);
        System.out.println("new updated student : " + studUpdated);
        return convertStudentToStudentDTO(studUpdated);
    }

    public String deleteById(long studId) {
        Student studById = iStudentDAO.findById(studId).get();
        iStudentDAO.delete(studById);
        return "successfully deleted";
    }

}

