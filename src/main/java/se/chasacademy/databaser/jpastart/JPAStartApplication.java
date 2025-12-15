package se.chasacademy.databaser.jpastart;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import se.chasacademy.databaser.jpastart.Models.Teacher;
import se.chasacademy.databaser.jpastart.Repositories.TeacherRepository;

@SpringBootApplication
public class JPAStartApplication implements CommandLineRunner {
    private TeacherRepository teacherRepository;

    JPAStartApplication(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(JPAStartApplication.class, args);
    }

	@Override
	public void run(String... args) {
        teacherRepository.save(new Teacher("adam.bertilsson@skolmail.se", "Adam Bertilsson"));
        teacherRepository.save(new Teacher("caesar.davidsson@skolmail.se", "Caesar Davidsson"));
	}
}
