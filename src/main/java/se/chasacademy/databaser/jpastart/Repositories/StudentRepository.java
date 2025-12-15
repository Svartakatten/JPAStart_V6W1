package se.chasacademy.databaser.jpastart.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se.chasacademy.databaser.jpastart.Models.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
