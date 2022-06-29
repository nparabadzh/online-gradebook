package bg.nbu.cscb634.onlinegradebook.services;

import bg.nbu.cscb634.onlinegradebook.model.Grades;
import bg.nbu.cscb634.onlinegradebook.repositories.GradesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
@Transactional
public class GradesService {
    @Autowired
    private GradesRepository gradesRepository;

    public List<Grades> findAll() {
        List<Grades> grades = gradesRepository.findAll();
        return grades;
    }

    public void addGrades(@ModelAttribute Grades grade) {
        gradesRepository.save(grade);
    }

    public Grades findGradesById(@PathVariable("id") int id) {
        Grades grade = gradesRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid grade Id:" + id));
        return grade;
    }

    public void updateGrades(@ModelAttribute Grades grade) throws Exception {
        Grades gradeInDB = gradesRepository.findById(grade.getId()).orElse(null);
        if (gradeInDB != null) {
;           gradeInDB.setGrade(grade.getGrade());
            gradeInDB.setSubject(grade.getSubject());
            gradeInDB.setDate(grade.getDate());
            gradeInDB.setStudent(grade.getStudent());
            gradesRepository.save(gradeInDB);
        } else {
            throw new Exception("Grades not found");
        }
    }

    public void deleteGrades(@PathVariable("id") int id) {
        Grades grade = gradesRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid grade Id:" + id));
        gradesRepository.delete(grade);
    }
}
