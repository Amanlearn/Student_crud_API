package com.example.model;

import javax.persistence.*;

@Entity
@Table(name="Student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="student_id")
    private long studentId;

    @Column(name="student_name")
    private String studentName;

    @Column(name="student_age")
    private int studentAge;

    @Column(name="student_city")
    private String city;

    @Column(name="student_mobileNumber")
    private String mobileNumber;

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getStudentAge() {
        return studentAge;
    }

    public void setStudentAge(int studentAge) {
        this.studentAge = studentAge;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public Student() {
    }

    public Student(long studentId, String studentName, int studentAge, String city, String mobileNumber) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentAge = studentAge;
        this.city = city;
        this.mobileNumber = mobileNumber;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                ", studentAge=" + studentAge +
                ", city='" + city + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                '}';
    }
}
