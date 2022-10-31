package io.knoldus.service;

import io.knoldus.entity.Course;
import io.knoldus.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * The type Course service.
 */
@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    /**
     * Find by course id course.
     *
     * @param courseId the course id
     * @return the course
     */
    public Course findByCourseId(Long courseId) {
        return CourseRepository.findByCourseId(courseId);
    }

    /**
     * Add.
     *
     * @param course the course
     */
    public void add(Course course) {
        courseRepository.add(course);
    }

    /**
     * Delete.
     *
     * @param courseId the course id
     */
    public void delete(Long courseId) {
        courseRepository.delete(courseId);
    }
}
