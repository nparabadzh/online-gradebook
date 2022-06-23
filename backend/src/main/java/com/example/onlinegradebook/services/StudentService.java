package com.example.onlinegradebook.services;

import com.example.onlinegradebook.model.Student;
import com.example.onlinegradebook.repositories.StudentRepository;
import com.example.onlinegradebook.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
@Transactional
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private UserRepository userRepository;

    public List<Student> findAll() {
        List<Student> students = studentRepository.findAll();
        return students;
    }

    public void addStudent(@ModelAttribute Student student) {
        userRepository.save(student.getUser());
        studentRepository.save(student);
    }

    public Student findStudentById(@PathVariable("id") int id) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + id));
        return student;
    }

    public void updateStudent(@ModelAttribute Student student) throws Exception {
        Student studentInDB = studentRepository.findById(student.getId()).orElse(null);
        if (studentInDB != null) {
            studentInDB.setUser(student.getUser());
            studentInDB.setSchoolClass(student.getSchoolClass());
            userRepository.save(studentInDB.getUser());
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
