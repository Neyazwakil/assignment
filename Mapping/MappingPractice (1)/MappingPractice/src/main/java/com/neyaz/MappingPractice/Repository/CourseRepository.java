package com.neyaz.MappingPractice.Repository;

import com.neyaz.MappingPractice.Model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course,String> {
}
