package io.knoldus.controller;

import io.knoldus.entity.Course;
import io.knoldus.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * The type Course controller.
 */
@RestController("/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    /**
     * Create course.
     *
     * @param course            the course
     * @param componentsBuilder the components builder
     */
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createCourse(@RequestBody Course course, UriComponentsBuilder componentsBuilder) {
        courseService.add(course);
    }
}