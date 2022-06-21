package com.example.onlinegradebook.services;

import com.example.onlinegradebook.model.SchoolSchedule;
import com.example.onlinegradebook.repositories.SchoolScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
@Transactional
public class SchoolScheduleServices {
    @Autowired
    private SchoolScheduleRepository schoolScheduleRepository;

    public List<SchoolSchedule> findAll() {
        List<SchoolSchedule> schoolSchedules = schoolScheduleRepository.findAll();
        return schoolSchedules;
    }

    public void addSchoolSchedule(@ModelAttribute SchoolSchedule schoolSchedule) {
        schoolScheduleRepository.save(schoolSchedule);
    }

    public SchoolSchedule findSchoolScheduleById(@PathVariable("id") int id) {
        SchoolSchedule schoolSchedule = schoolScheduleRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid schoolSchedule Id:" + id));
        return schoolSchedule;
    }

    public void updateSchoolSchedule(@ModelAttribute SchoolSchedule schoolSchedule) throws Exception {
        SchoolSchedule schoolScheduleInDB = schoolScheduleRepository.findById(schoolSchedule.getID()).orElse(null);
        if (schoolScheduleInDB != null) {
            schoolScheduleInDB.setSubject(schoolSchedule.getSubject());
            schoolScheduleInDB.setWeekDay(schoolSchedule.getWeekDay());
            schoolScheduleInDB.setStartsAt(schoolSchedule.getStartsAt());
            schoolScheduleInDB.setEndsAt(schoolSchedule.getEndsAt());
            schoolScheduleRepository.save(schoolScheduleInDB);
        } else {
            throw new Exception("SchoolSchedule not found");
        }
    }

    public void deleteSchoolSchedule(@PathVariable("id") int id) {
        SchoolSchedule schoolSchedule = schoolScheduleRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid schoolSchedule Id:" + id));
        schoolScheduleRepository.delete(schoolSchedule);
    }
}
