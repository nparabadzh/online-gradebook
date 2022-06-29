package bg.nbu.cscb634.onlinegradebook.services;

import bg.nbu.cscb634.onlinegradebook.repositories.SchoolRepository;
import bg.nbu.cscb634.onlinegradebook.model.School;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
@Transactional
public class SchoolService {
    @Autowired
    private SchoolRepository schoolRepository;

    public List<School> findAll() {
        List<School> schools = schoolRepository.findAll();
        return schools;
    }

    public void addSchool(@ModelAttribute School school) {
        schoolRepository.save(school);
    }

    public School findSchoolById(@PathVariable("id") int id) {
        School school = schoolRepository.findById(id).
                orElseThrow(() -> new IllegalArgumentException("Invalid school Id:" + id));
        return school;
    }

    public void updateSchool(@ModelAttribute School school) throws Exception {
        School schoolInDB = schoolRepository.findById(school.getId()).orElse(null);
        if (schoolInDB != null) {
            schoolInDB.setName(school.getName());
            schoolInDB.setAddress(school.getAddress());
            schoolRepository.save(schoolInDB);
        } else {
            throw new Exception("School not found");
        }
    }

    public void deleteSchool(@PathVariable("id") int id) {
        School school = schoolRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid school Id:" + id));
        schoolRepository.delete(school);
    }
}
