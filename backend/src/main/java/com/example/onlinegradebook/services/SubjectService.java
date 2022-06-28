package com.example.onlinegradebook.services;

import com.example.onlinegradebook.model.SchoolClass;
import com.example.onlinegradebook.model.Student;
import com.example.onlinegradebook.model.Subject;
import com.example.onlinegradebook.repositories.SubjectRepository;
import com.example.onlinegradebook.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class SubjectService {

    @Autowired
    private SubjectRepository subjectRepository;
    @Autowired
    private StudentRepository studentRepository;

    public List<Subject> findAll() {
        List<Subject> subjects = subjectRepository.findAll();
        return subjects;
    }

    public void addSubject(@ModelAttribute Subject subject) {
        subjectRepository.save(subject);
    }

    public Subject findSubjectById(@PathVariable("id") int id) {
        Subject subject = subjectRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid subject Id:" + id));
        return subject;
    }

    public void updateSubject(@ModelAttribute Subject subject) throws Exception {
        Subject subjectInDB = subjectRepository.findById(subject.getId()).orElse(null);
        if (subjectInDB != null) {
            subjectInDB.setSubject_name(subject.getSubject_name());
            subjectInDB.setTopics(subject.getTopics());
            subjectInDB.setSchoolClass(subject.getSchoolClass());
            subjectInDB.setTeacher(subject.getTeacher());
            subjectInDB.setGrades(subject.getGrades());
            subjectRepository.save(subjectInDB);
        } else {
            throw new Exception("Subject not found");
        }
    }

    public void deleteSubject(@PathVariable("id") int id) {
        Subject subject = subjectRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid subject Id:" + id));
        subjectRepository.delete(subject);
    }

    public List<Subject> findAllSubjectsForStudentWithId(@PathVariable("id") int id) {
        Optional<Student> student = studentRepository.findById(id);
        SchoolClass schoolClass = student.get().getSchoolClass();
        int forClass = schoolClass.getId();
        List<Subject> subjects = subjectRepository.getAllSubjectsForClassId(forClass);
        return subjects;
    }
}
