package com.student.studentdemo.Service;

import com.student.studentdemo.exception.NotFoundException;
import com.student.studentdemo.model.Student;
import com.student.studentdemo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private StudentRepository studentRepository;

    @Autowired
    public void setStudentRepository(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents(){
        return studentRepository.findAll();
    }

    public Student getStudentById(Long id){
        Optional<Student> student = studentRepository.findById(id);
       if (student.isEmpty()){
            throw new NotFoundException("Student not found");
       }
       return student.get();
    }

    public Student addStudent(Student st){
        return studentRepository.save(st);
    }
    public  Student updateStudent(Long id, Student stOject){
        Student student = getStudentById(id);
        student.setAddress(stOject.getAddress());
        student.setName(stOject.getName());
        return studentRepository.save(student);
    }

    public String deleteStudent(Long id){
        Student student = getStudentById(id);
       studentRepository.delete(student);
       return "Student deleted";
    }
}
