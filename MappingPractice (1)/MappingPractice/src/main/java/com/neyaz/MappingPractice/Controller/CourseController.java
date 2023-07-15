package com.neyaz.MappingPractice.Controller;

import com.neyaz.MappingPractice.Model.Course;
import com.neyaz.MappingPractice.Service.CourseService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
@Data

@RestController
@RequestMapping("/courses")
public class CourseController {
    private final CourseService courseService;
@Autowired
@GetMapping
public List<Course> getAllCourses() {
    return courseService.getAllCourse();
}

    @GetMapping("/{id}")
    public Course getCourseById(@PathVariable("id") String id) {
        return courseService.getCourseById(id);
    }

    @PostMapping
    public Course createCourse(@RequestBody Course course) {
        return courseService.createCourse(course);
    }

    @PutMapping("/{id}")
    public Course updateCourse(@PathVariable("id") String id, @RequestBody Course course) {
        course.setCourseID(id);
        return courseService.updateCourse(course);
    }

    @DeleteMapping("/{id}")
    public void deleteCourse(@PathVariable("id") String id) {
        courseService.deleteCourse(id);
    }
}
