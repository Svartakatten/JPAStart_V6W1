package se.chasacademy.databaser.jpastart.Data;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import se.chasacademy.databaser.jpastart.Models.Course;
import se.chasacademy.databaser.jpastart.Models.Student;
import se.chasacademy.databaser.jpastart.Models.Teacher;
import se.chasacademy.databaser.jpastart.Repositories.CourseRepository;
import se.chasacademy.databaser.jpastart.Repositories.StudentRepository;
import se.chasacademy.databaser.jpastart.Repositories.TeacherRepository;

import javax.xml.crypto.Data;
import java.util.List;

@Component
public class DataInitializer implements CommandLineRunner {
    private final TeacherRepository teacherRepository;
    private final CourseRepository courseRepository;
    private final StudentRepository studentRepository;

    public DataInitializer(TeacherRepository teacherRepository,
                           CourseRepository courseRepository,
                           StudentRepository studentRepository) {
        this.teacherRepository = teacherRepository;
        this.courseRepository = courseRepository;
        this.studentRepository = studentRepository;
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        System.out.println("Startar datainitiering");

        // teachers
        Teacher teacher1 = new Teacher("Magister Haddock", "haddock@sea.com");
        Teacher teacher2 = new Teacher("Professor Kalkyl", "kalkyl@science.com");

        teacherRepository.saveAll(List.of(teacher1, teacher2));

        Course course1 = new Course("Sjörätt", "SEA101", teacher1);
        Course course2 = new Course("Navigering", "NAV202", teacher1);
        Course course3 = new Course("Raketforskning", "ROC9000", teacher2);

        courseRepository.saveAll(List.of(course1, course2, course3));

        Student student1 = new Student("Tintin", "tintin@reporter.com");
        Student student2 = new Student("Milou", "milou@dog.com");
        Student student3 = new Student("Dupondt", "police@agency.com");

        studentRepository.saveAll(List.of(student1, student2, student3));

        course1.addStudent(student1);
        course2.addStudent(student1);
        course3.addStudent(student1);

        course1.addStudent(student2);

        course3.addStudent(student3);

        courseRepository.saveAll(List.of(course1, course2, course3));

        System.out.println("Data sparad");

        Course fetchedCourse = courseRepository.findById(course1.getId()).orElse(null);
        if (fetchedCourse != null) {
            System.out.println("\nKurs: " + fetchedCourse.getTitle());
            System.out.println("Lärare: " + fetchedCourse.getTeacher().getName());
            System.out.println("Studenter:");
            for (Student s : fetchedCourse.getStudents()) {
                System.out.println(" - " + s.getName());
            }
        }

        Student fetchedStudent = studentRepository.findById(student1.getId()).orElse(null);
        if (fetchedStudent != null) {
            System.out.println("\nStudent: " + fetchedStudent.getName());
            System.out.println("Läser Kurser:");
            for (Course c : fetchedStudent.getCourses()) {
                System.out.println(" - " + c.getTitle() + " (Lärare: " + c.getTeacher().getName() + ")");
            }
        }
    }

}
