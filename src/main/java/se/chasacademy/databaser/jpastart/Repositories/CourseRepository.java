package se.chasacademy.databaser.jpastart.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se.chasacademy.databaser.jpastart.Models.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
}
