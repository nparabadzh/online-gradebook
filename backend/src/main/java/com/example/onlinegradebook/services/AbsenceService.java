package com.example.onlinegradebook.services;

import com.example.onlinegradebook.model.Absence;
import com.example.onlinegradebook.repositories.AbsenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
@Transactional
public class AbsenceService {
    @Autowired
    private AbsenceRepository absenceRepository;

    public List<Absence> findAll() {
        List<Absence> absences = absenceRepository.findAll();
        return absences;
    }

    public void addAbsence(@ModelAttribute Absence absence) {
        absenceRepository.save(absence);
    }

    public Absence findAbsenceById(@PathVariable("id") int id) {
        Absence absence = absenceRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid absence Id:" + id));
        return absence;
    }

    public void updateAbsence(@ModelAttribute Absence absence) throws Exception {
        Absence absenceInDB = absenceRepository.findById(absence.getId()).orElse(null);
        if (absenceInDB != null) {
            absenceInDB.setStudent(absence.getStudent());
            absenceInDB.setDay(absence.getDay());
            absenceInDB.setSchoolHour(absence.getSchoolHour());
            absenceInDB.setStatus(absence.getStatus());
            absenceRepository.save(absenceInDB);
        } else {
            throw new Exception("Absence not found");
        }
    }

    public void deleteAbsence(@PathVariable("id") int id) {
        Absence absence = absenceRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid absence Id:" + id));
        absenceRepository.delete(absence);
    }
}
