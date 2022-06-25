package com.example.onlinegradebook.services;

import com.example.onlinegradebook.model.SchoolClass;
import com.example.onlinegradebook.repositories.SchoolClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class SchoolClassService {
    @Autowired
    private SchoolClassRepository schoolClassRepository;

    public List<SchoolClass> findAll() {
        List<SchoolClass> schoolClasss = schoolClassRepository.findAll();
        return schoolClasss;
    }

    public void addSchoolClass(@ModelAttribute SchoolClass schoolClass) {
        schoolClassRepository.save(schoolClass);
    }

    public SchoolClass findSchoolClassById(@PathVariable("id") int id) {
        SchoolClass schoolClass = schoolClassRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid schoolClass Id:" + id));
        return schoolClass;
    }

    public void updateSchoolClass(@ModelAttribute SchoolClass schoolClass) throws Exception {
        SchoolClass schoolClassInDB = schoolClassRepository.findById(schoolClass.getId()).orElse(null);
        if (schoolClassInDB != null) {
            schoolClassInDB.setYear(schoolClass.getYear());
            schoolClassInDB.setClassInitialization(schoolClass.getClassInitialization());
            schoolClassInDB.setSchool(schoolClass.getSchool());
            schoolClassInDB.setStudents(schoolClass.getStudents());
            schoolClassInDB.setSubjects(schoolClass.getSubjects());
            schoolClassRepository.save(schoolClassInDB);
        } else {
            throw new Exception("SchoolClass not found");
        }
    }

    public void deleteSchoolClass(@PathVariable("id") int id) {
        SchoolClass schoolClass = schoolClassRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid schoolClass Id:" + id));
        schoolClassRepository.delete(schoolClass);
    }
}
