package com.example.onlinegradebook.services;

import com.example.onlinegradebook.model.Studies;
import com.example.onlinegradebook.repositories.StudiesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
@Transactional
public class StudiesServices {
    @Autowired
    private StudiesRepository studiesRepository;

    public List<Studies> findAll() {
        List<Studies> studies = studiesRepository.findAll();
        return studies;
    }

    public void addStudies(@ModelAttribute Studies studies) {
        studiesRepository.save(studies);
    }

    public Studies findStudiesById(@PathVariable("id") int id) {
        Studies studies = studiesRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid studies Id:" + id));
        return studies;
    }

    public void updateStudies(@ModelAttribute Studies studies) throws Exception {
        Studies studiesInDB = studiesRepository.findById(studies.getID()).orElse(null);
        if (studiesInDB != null) {
            studiesInDB.setSubject(studies.getSubject());
            studiesInDB.setGrade(studies.getGrade());
            studiesInDB.setStudent(studies.getStudent());
            studiesRepository.save(studiesInDB);
        } else {
            throw new Exception("Studies not found");
        }
    }

    public void deleteStudies(@PathVariable("id") int id) {
        Studies studies = studiesRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid studies Id:" + id));
        studiesRepository.delete(studies);
    }
}
