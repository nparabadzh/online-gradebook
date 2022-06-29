package bg.nbu.cscb634.onlinegradebook.services;

import bg.nbu.cscb634.onlinegradebook.repositories.StudentRepository;
import bg.nbu.cscb634.onlinegradebook.repositories.UserRepository;
import bg.nbu.cscb634.onlinegradebook.model.School;
import bg.nbu.cscb634.onlinegradebook.model.SchoolClass;
import bg.nbu.cscb634.onlinegradebook.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
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

    public List<Student> findAllStudentsBySchool(@PathVariable("id") int id){
        School school = this.studentRepository.getById(id).getSchoolClass().getSchool();
        List<Student> studentIsFromSchool = new ArrayList<>();
        school.getClasses().stream().forEach(o -> studentIsFromSchool.addAll(o.getStudents()));
        return studentIsFromSchool;
    }

    public List<Student> findAllStudentsByClass(@PathVariable("id") int id){
        SchoolClass schoolClass = this.studentRepository.getById(id).getSchoolClass();
        List<Student> studentIsFromSchool = new ArrayList<>();
        schoolClass.getStudents().stream().forEach(o -> studentIsFromSchool.addAll(o.getSchoolClass().getStudents()));
        return studentIsFromSchool;
    }
}
