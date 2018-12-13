package com.jcg.hibernate.crud.operations;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "student")
public class Student implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "student_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "student_name")
    private String studentName;

    @Column (name = "rollnumber")
    private int rollNumber;

    @Column(name = "course")
    private String course;

    public void setId(int id) {
        this.id = id;
    }
    public String getStudentName() {
        return studentName;
    }
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
    public int getRollNumber() {
        return getRollNumber();
    }
    public void setRollNumber(int rollNumber) {
        this.rollNumber = rollNumber;
    }
    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }
    @Override
    public String toString(){
        return "Student details?= ID: " + this.id + "Roll No.: " + this.rollNumber + "Course: " + this.course;
    }
}
