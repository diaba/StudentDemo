package com.student.studentdemo.controller;

import com.student.studentdemo.Service.StudentService;
import com.student.studentdemo.model.Student;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {
    private StudentService studentService;

    @Autowired
    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/hello")
    public String sayHello(){
        return "Hello";
    }
    @GetMapping("/students")
    public List<Student> getStudents(){
        return studentService.getStudents();
    }

    @GetMapping("/students/{studentId}")
    public Student getStudentById(@PathVariable Long studentId){
        return studentService.getStudentById(studentId);
    }
    @PostMapping("/students")
    public Student addStudent(@RequestBody Student student){
        return studentService.addStudent(student);
    }
    @PutMapping("/students/{studentId}")
    public Student updateStudent(@PathVariable Long studentId, @RequestBody Student student){
        return studentService.updateStudent(studentId,student);
    }
    @DeleteMapping("/students/{studentId}")
    public  String deleteStudent(@PathVariable Long studentId){
        return studentService.deleteStudent(studentId);
    }
}
