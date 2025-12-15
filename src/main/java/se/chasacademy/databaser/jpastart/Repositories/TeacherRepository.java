package se.chasacademy.databaser.jpastart.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import se.chasacademy.databaser.jpastart.Models.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
    Teacher findById(long id);
}
