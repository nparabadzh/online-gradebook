package com.example.onlinegradebook.services;


import com.example.onlinegradebook.constant.*;
import com.example.onlinegradebook.constant.Class;
import com.example.onlinegradebook.model.*;
import com.example.onlinegradebook.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

@Component
public class DataInitializerService implements CommandLineRunner {
    @Autowired
    private AbsenceRepository absenceRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ParentRepository parentRepository;

    @Autowired
    private SchoolRepository schoolRepository;

    @Autowired
    private SchoolScheduleRepository schoolScheduleRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudiesRepository studiesRepository;

    @Autowired
    private SubjectRepository subjectRepository;

    @Autowired
    private TopicRepository topicRepository;

    @Autowired
    private UserRepository userRepository;

    public DataInitializerService(AbsenceRepository absenceRepository, EmployeeRepository employeeRepository,
                                  ParentRepository parentRepository, SchoolRepository schoolRepository,
                                  SchoolScheduleRepository schoolScheduleRepository, StudentRepository studentRepository,
                                  StudiesRepository studiesRepository, SubjectRepository subjectRepository,
                                  TopicRepository topicRepository, UserRepository userRepository) {
        this.absenceRepository = absenceRepository;
        this.employeeRepository = employeeRepository;
        this.parentRepository = parentRepository;
        this.schoolRepository = schoolRepository;
        this.schoolScheduleRepository = schoolScheduleRepository;
        this.studentRepository = studentRepository;
        this.studiesRepository = studiesRepository;
        this.subjectRepository = subjectRepository;
        this.topicRepository = topicRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        //Creating Schools
//        schoolRepository.save(new School(0, "Petko Slaveikov", "Mladost str., Varna"));
//        schoolRepository.save(new  School(0, "Peio Yavorov", "Svoboda str., Sofia"));

        //Creating Employees
//        employeeRepository.save(new Employee("Stefan Stefanov", "6805120979", "Place A",
//                RoleType.DIRECTOR, "Math", 1800));
//        employeeRepository.save(new Employee("Pavel Dimitrov", "7508069415", "Place B",
//                RoleType.TEACHER, "History", 1500));
//        employeeRepository.save(new Employee("Adriana Mileva", "8912243645", "Place D",
//                RoleType.TEACHER, "Sports", 1400));
//        employeeRepository.save(new Employee("Kristian Pavlov", "6805120979", "Place E",
//                RoleType.DIRECTOR, "Philosophy", 2200));
//        employeeRepository.save(new Employee("Maria Petrova", "8912243645", "Place G",
//                RoleType.TEACHER, "English", 1700));
//        employeeRepository.save(new Employee("Elisaveta Gospodinova", "7508069415", "Place F",
//                RoleType.TEACHER, "Business", 1600));

        //Generating Students
//        studentRepository.save(new Student("Ivanka Rumenova", "1009162545", "Place C",
//                RoleType.STUDENT, Year.fifth, Class.A));
//        studentRepository.save(new Student("Plamen Rumenov", "0806015696", "Place C",
//                RoleType.STUDENT, Year.seventh, Class.B));
//        studentRepository.save(new Student("Nikol Tosheva", "1009162545", "Place H",
//                RoleType.STUDENT, Year.fifth, Class.A));
//        studentRepository.save(new Student("Elena Bukova", "0806015696", "Place H",
//                RoleType.STUDENT, Year.seventh, Class.A));

        //Generating Parents
//        List<Student> childrenOfParent1 = new ArrayList<>();
//        childrenOfParent1.add(studentRepository.getById(1));
//        childrenOfParent1.add(studentRepository.getById(2));
//        parentRepository.save(new Parent("Petar Rumenov", "7506040506", "Place C", RoleType.PARENT, childrenOfParent1));
//
//        List<Student> childrenOfParent2 = new ArrayList<>();
//        childrenOfParent2.add(studentRepository.getById(3));
//        childrenOfParent2.add(studentRepository.getById(4));
//        parentRepository.save(new Parent("Violeta Bobeva", "7506040506", "Place H", RoleType.PARENT, childrenOfParent2));

        //Creating Topics
//        topicRepository.save(new Topic("Triangle", true, Date.valueOf("2022-06-21")));
//        topicRepository.save(new Topic("Algebra", false, null));
//        topicRepository.save(new Topic("Stereometry", false, null));
//        topicRepository.save(new Topic("Statistics", false, null));
//        topicRepository.save(new Topic("Troya", true, Date.valueOf("2022-06-21")));
//        topicRepository.save(new Topic("Tsar Boris I", false, null));
//        topicRepository.save(new Topic("Khan Krum", false, null));
//        topicRepository.save(new Topic("Tsar Simeon Veliki", false, null));
//        topicRepository.save(new Topic("Khan Omurtak", false, null));
//        topicRepository.save(new Topic("Freedom", false, null));
//        topicRepository.save(new Topic("Rights", false, null));
//        topicRepository.save(new Topic("Religion", false, null));
//        topicRepository.save(new Topic("Verbs", false, null));
//        topicRepository.save(new Topic("Verb tenses", false, null));
//        topicRepository.save(new Topic("Past Simple", false, null));
//        topicRepository.save(new Topic("Present Simple", false, null));
//        topicRepository.save(new Topic("Football", false, null));
//        topicRepository.save(new Topic("Fitness", false, null));
//        topicRepository.save(new Topic("Basketball", false, null));
//        topicRepository.save(new Topic("Running", false, null));
//        topicRepository.save(new Topic("Economics", false, null));
//        topicRepository.save(new Topic("Finances", false, null));

        //Creating Subjects
//        List<Topic> mathTopics = new ArrayList<>();
//        mathTopics.add(topicRepository.getById(1));
//        mathTopics.add(topicRepository.getById(2));
//        mathTopics.add(topicRepository.getById(3));
//        mathTopics.add(topicRepository.getById(4));
//        List<Employee> mathTeachers = new ArrayList<>();
//        mathTeachers.add(employeeRepository.getById(1));
//        subjectRepository.save(new Subject(mathTeachers, mathTopics, Year.fifth));
//
//        List<Topic> history = new ArrayList<>();
//        history.add(topicRepository.getById(5));
//        history.add(topicRepository.getById(6));
//        history.add(topicRepository.getById(7));
//        history.add(topicRepository.getById(8));
//        history.add(topicRepository.getById(9));
//        List<Employee> historyTeachers = new ArrayList<>();
//        historyTeachers.add(employeeRepository.getById(2));
//        subjectRepository.save(new Subject(historyTeachers, history, Year.fifth));
//
//        List<Topic> philosophy = new ArrayList<>();
//        philosophy.add(topicRepository.getById(10));
//        philosophy.add(topicRepository.getById(11));
//        philosophy.add(topicRepository.getById(12));
//        List<Employee> philosophyTeachers = new ArrayList<>();
//        philosophyTeachers.add(employeeRepository.getById(3));
//        subjectRepository.save(new Subject(philosophyTeachers, philosophy, Year.seventh));
//
//        List<Topic> english = new ArrayList<>();
//        english.add(topicRepository.getById(13));
//        english.add(topicRepository.getById(14));
//        english.add(topicRepository.getById(15));
//        english.add(topicRepository.getById(16));
//        List<Employee> englishTeachers = new ArrayList<>();
//        englishTeachers.add(employeeRepository.getById(4));
//        subjectRepository.save(new Subject(englishTeachers, english, Year.fifth));
//
//        List<Topic> sports = new ArrayList<>();
//        sports.add(topicRepository.getById(17));
//        sports.add(topicRepository.getById(18));
//        sports.add(topicRepository.getById(19));
//        sports.add(topicRepository.getById(20));
//        List<Employee> sportsTeachers = new ArrayList<>();
//        sportsTeachers.add(employeeRepository.getById(5));
//        subjectRepository.save(new Subject(sportsTeachers, sports, Year.seventh));
//
//        List<Topic> business = new ArrayList<>();
//        business.add(topicRepository.getById(21));
//        business.add(topicRepository.getById(22));
//        List<Employee> businessTeachers = new ArrayList<>();
//        businessTeachers.add(employeeRepository.getById(6));
//        subjectRepository.save(new Subject(businessTeachers, business, Year.seventh));

        //Creating Studies
//        studiesRepository.save(new Studies(studentRepository.getById(7), subjectRepository.getById(1), 6));
//        studiesRepository.save(new Studies(studentRepository.getById(7), subjectRepository.getById(2), 5));
//        studiesRepository.save(new Studies(studentRepository.getById(8), subjectRepository.getById(3), 4));
//        studiesRepository.save(new Studies(studentRepository.getById(9), subjectRepository.getById(4), 2));
//        studiesRepository.save(new Studies(studentRepository.getById(9), subjectRepository.getById(5), 6));
//        studiesRepository.save(new Studies(studentRepository.getById(10), subjectRepository.getById(6), 3));

        //Creating SchoolSchedule
//        schoolScheduleRepository.save(new SchoolSchedule(WeekDay.MONDAY, subjectRepository.getById(1),
//                Time.valueOf("09:00:00"), Time.valueOf("09:40:00")));
//        schoolScheduleRepository.save(new SchoolSchedule(WeekDay.MONDAY, subjectRepository.getById(2),
//                Time.valueOf("09:50:00"), Time.valueOf("10:30:00")));
//        schoolScheduleRepository.save(new SchoolSchedule(WeekDay.MONDAY, subjectRepository.getById(3),
//                Time.valueOf("09:00:00"), Time.valueOf("09:40:00")));
//        schoolScheduleRepository.save(new SchoolSchedule(WeekDay.MONDAY, subjectRepository.getById(4),
//                Time.valueOf("09:00:00"), Time.valueOf("09:40:00")));
//        schoolScheduleRepository.save(new SchoolSchedule(WeekDay.MONDAY, subjectRepository.getById(5),
//                Time.valueOf("09:50:00"), Time.valueOf("10:30:00")));
//        schoolScheduleRepository.save(new SchoolSchedule(WeekDay.MONDAY, subjectRepository.getById(6),
//                Time.valueOf("09:00:00"), Time.valueOf("09:40:00")));

        //Creating Absences
//        absenceRepository.save(new Absence(Date.valueOf("2022-06-21"), schoolScheduleRepository.getById(1),
//                studentRepository.getById(1), AbsenceStatus.UnExcused));
//        absenceRepository.save(new Absence(Date.valueOf("2022-06-21"), schoolScheduleRepository.getById(2),
//                studentRepository.getById(1), AbsenceStatus.UnExcused));
    }
}
