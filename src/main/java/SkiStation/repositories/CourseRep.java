package SkiStation.repositories;

import SkiStation.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRep extends JpaRepository<Course, Long> {
}
