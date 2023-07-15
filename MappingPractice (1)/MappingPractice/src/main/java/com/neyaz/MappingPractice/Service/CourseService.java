package com.neyaz.MappingPractice.Service;

import com.neyaz.MappingPractice.Model.Course;
import com.neyaz.MappingPractice.Repository.CourseRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CourseService {
    private  final CourseRepository courseRepository;
    @Autowired
    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public List<Course> getAllCourse(){
        return courseRepository.findAll();

    }
    public Course getCourseById(String Id){

        return courseRepository.findById(Id).orElse(null);

    }
    public Course createCourse(Course course){
        return courseRepository.save(course);
    }

    public Course updateCourse(Course course){
        return courseRepository.save(course);
    }
    public void deleteCourse(String Id){
        courseRepository.deleteById(Id);

    }
}
