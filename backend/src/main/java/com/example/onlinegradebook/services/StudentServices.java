package com.example.onlinegradebook.services;

import com.example.onlinegradebook.model.Student;
import com.example.onlinegradebook.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
@Transactional
public class StudentServices {
    @Autowired
    private StudentRepository studentRepository;

    public List<Student> findAll() {
        List<Student> students = studentRepository.findAll();
        return students;
    }

    public void addStudent(@ModelAttribute Student student) {
        studentRepository.save(student);
    }

    public Student findStudentById(@PathVariable("id") int id) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + id));
        return student;
    }

    public void updateStudent(@ModelAttribute Student student) throws Exception {
        Student studentInDB = studentRepository.findById(student.getID()).orElse(null);
        if (studentInDB != null) {
            studentInDB.setName(student.getName());
            studentInDB.setEGN(student.getEGN());
            studentInDB.setAddress(student.getAddress());
            studentInDB.setRole(student.getRole());
            studentInDB.setYear(student.getYear());
            studentInDB.setClasses(student.getClasses());
            studentRepository.save(studentInDB);
        } else {
            throw new Exception("Student not found");
        }
    }

    public void deleteStudent(@PathVariable("id") int id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + id));
        studentRepository.delete(student);
    }
}
