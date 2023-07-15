package com.neyaz.MappingPractice.Repository;

import com.neyaz.MappingPractice.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,String> {
}
