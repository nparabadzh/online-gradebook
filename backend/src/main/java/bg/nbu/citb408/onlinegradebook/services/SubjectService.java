package bg.nbu.citb408.onlinegradebook.services;

import bg.nbu.citb408.onlinegradebook.repositories.SubjectRepository;
import bg.nbu.citb408.onlinegradebook.model.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
@Transactional
public class SubjectService {
    @Autowired
    private SubjectRepository subjectRepository;

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
            subjectInDB.setTopics(subject.getTopics());
            subjectInDB.setIntendedFor(subject.getIntendedFor());
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
}
