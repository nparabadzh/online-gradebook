package com.example.onlinegradebook.services;


import com.example.onlinegradebook.constant.*;
import com.example.onlinegradebook.constant.ClassInitialization;
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

    @Autowired
    private SchoolClassRepository schoolClassRepository;

    @Autowired
    private GradesRepository gradesRepository;

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
//        //Creating Users
//        userRepository.save(new User("Stefan Stefanov", "6805120979", "Place A", RoleType.DIRECTOR));
//        userRepository.save(new User("Pavel Dimitrov", "7508069415", "Place B", RoleType.TEACHER));
//        userRepository.save(new User("Adriana Mileva", "8912243645", "Place D", RoleType.TEACHER));
//        userRepository.save(new User("Kristian Pavlov", "6805120979", "Place E", RoleType.DIRECTOR));
//        userRepository.save(new User("Maria Petrova", "8912243645", "Place G", RoleType.TEACHER));
//        userRepository.save(new User("Elisaveta Gospodinova", "7508069415", "Place F", RoleType.TEACHER));
//        userRepository.save(new User("Ivanka Rumenova", "1009162545", "Place C", RoleType.STUDENT));
//        userRepository.save(new User("Plamen Rumenov", "0806015696", "Place C", RoleType.STUDENT));
//        userRepository.save(new User("Nikol Tosheva", "1009162545", "Place H", RoleType.STUDENT));
//        userRepository.save(new User("Elena Bukova", "0806015696", "Place H", RoleType.STUDENT));
//        userRepository.save(new User("Petar Rumenov", "7506040506", "Place C", RoleType.PARENT));
//        userRepository.save(new User("Violeta Bobeva", "7506040506", "Place H", RoleType.PARENT));
//
//        //Creating Schools
//        schoolRepository.save(new School("Petko Slaveikov", "Mladost str., Varna", null));
//        schoolRepository.save(new  School("Peio Yavorov", "Svoboda str., Sofia", null));

//        //Creating Classes
//        schoolClassRepository.save(new SchoolClass(Year.fifth, ClassInitialization.A, schoolRepository.getById(1),
//                null, null));
//        schoolClassRepository.save(new SchoolClass(Year.seventh, ClassInitialization.A, schoolRepository.getById(1),
//                null, null));
//        schoolClassRepository.save(new SchoolClass(Year.fifth, ClassInitialization.A, schoolRepository.getById(2),
//                null, null));
//        schoolClassRepository.save(new SchoolClass(Year.seventh, ClassInitialization.A, schoolRepository.getById(2),
//                null, null));
//
//        //Creating Employees
//        employeeRepository.save(new Employee(userRepository.getById(1), "Math", 1800,
//                schoolRepository.getById(1)));
//        employeeRepository.save(new Employee(userRepository.getById(2), "History", 1500,
//                schoolRepository.getById(1)));
//        employeeRepository.save(new Employee(userRepository.getById(3), "Sports", 1400,
//                schoolRepository.getById(1)));
//        employeeRepository.save(new Employee(userRepository.getById(4), "Philosophy", 2200,
//                schoolRepository.getById(2)));
//        employeeRepository.save(new Employee(userRepository.getById(5), "English", 1700,
//                schoolRepository.getById(2)));
//        employeeRepository.save(new Employee(userRepository.getById(6), "Business", 1600,
//                schoolRepository.getById(2)));
//
//        //Generating Parents
//        parentRepository.save(new Parent(userRepository.getById(11), studentRepository.getById(1)));
//        parentRepository.save(new Parent(userRepository.getById(11), studentRepository.getById(2)));
//        parentRepository.save(new Parent(userRepository.getById(12), studentRepository.getById(3)));
//        parentRepository.save(new Parent(userRepository.getById(12), studentRepository.getById(4)));
//
//        //Creating Topics
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
//
//        //Creating Subjects
//        subjectRepository.save(new Subject(employeeRepository.getById(1), topicRepository.getById(1), Year.fifth));
//        subjectRepository.save(new Subject(employeeRepository.getById(1), topicRepository.getById(2), Year.fifth));
//        subjectRepository.save(new Subject(employeeRepository.getById(1), topicRepository.getById(3), Year.fifth));
//        subjectRepository.save(new Subject(employeeRepository.getById(1), topicRepository.getById(4), Year.fifth));
//
//        subjectRepository.save(new Subject(employeeRepository.getById(2), topicRepository.getById(5), Year.fifth));
//        subjectRepository.save(new Subject(employeeRepository.getById(2), topicRepository.getById(6), Year.fifth));
//        subjectRepository.save(new Subject(employeeRepository.getById(2), topicRepository.getById(7), Year.fifth));
//        subjectRepository.save(new Subject(employeeRepository.getById(2), topicRepository.getById(8), Year.fifth));
//        subjectRepository.save(new Subject(employeeRepository.getById(2), topicRepository.getById(9), Year.fifth));
//
//        subjectRepository.save(new Subject(employeeRepository.getById(3), topicRepository.getById(10), Year.seventh));
//        subjectRepository.save(new Subject(employeeRepository.getById(3), topicRepository.getById(11), Year.seventh));
//        subjectRepository.save(new Subject(employeeRepository.getById(3), topicRepository.getById(12), Year.seventh));
//
//;       subjectRepository.save(new Subject(employeeRepository.getById(4), topicRepository.getById(13), Year.fifth));
//        subjectRepository.save(new Subject(employeeRepository.getById(4), topicRepository.getById(14), Year.fifth));
//        subjectRepository.save(new Subject(employeeRepository.getById(4), topicRepository.getById(15), Year.fifth));
//        subjectRepository.save(new Subject(employeeRepository.getById(4), topicRepository.getById(16), Year.fifth));
//
//        subjectRepository.save(new Subject(employeeRepository.getById(5), topicRepository.getById(17), Year.seventh));
//        subjectRepository.save(new Subject(employeeRepository.getById(5), topicRepository.getById(18), Year.seventh));
//        subjectRepository.save(new Subject(employeeRepository.getById(5), topicRepository.getById(19), Year.seventh));
//        subjectRepository.save(new Subject(employeeRepository.getById(5), topicRepository.getById(20), Year.seventh));
//
//        subjectRepository.save(new Subject(employeeRepository.getById(6), topicRepository.getById(21), Year.seventh));
//        subjectRepository.save(new Subject(employeeRepository.getById(6), topicRepository.getById(22), Year.seventh));
//
//        //Creating Grades
//        gradesRepository.save(new Grades(subjectRepository.getById(1), 6, Date.valueOf("2022-06-21")));

//        //Generating Students
//        studentRepository.save(new Student(userRepository.getById(7), schoolClassRepository.getById(1), null));
//        studentRepository.save(new Student(userRepository.getById(8), schoolClassRepository.getById(2), gradesRepository.getById(1)));
//        studentRepository.save(new Student(userRepository.getById(9), schoolClassRepository.getById(3), null));
//        studentRepository.save(new Student(userRepository.getById(10), schoolClassRepository.getById(4), null));
//
//        //Creating Studies
//        studiesRepository.save(new Studies(schoolClassRepository.getById(1), subjectRepository.getById(1)));
//        studiesRepository.save(new Studies(schoolClassRepository.getById(1), subjectRepository.getById(2)));
//        studiesRepository.save(new Studies(schoolClassRepository.getById(2), subjectRepository.getById(3)));
//        studiesRepository.save(new Studies(schoolClassRepository.getById(3), subjectRepository.getById(4)));
//        studiesRepository.save(new Studies(schoolClassRepository.getById(4), subjectRepository.getById(5)));
//        studiesRepository.save(new Studies(schoolClassRepository.getById(4), subjectRepository.getById(6)));
//
//        //Creating SchoolSchedule
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
//
//        //Creating Absences
//        absenceRepository.save(new Absence(Date.valueOf("2022-06-21"), schoolScheduleRepository.getById(1),
//                studentRepository.getById(1), AbsenceStatus.UnExcused));
//        absenceRepository.save(new Absence(Date.valueOf("2022-06-21"), schoolScheduleRepository.getById(2),
//                studentRepository.getById(1), AbsenceStatus.UnExcused));
    }
}
