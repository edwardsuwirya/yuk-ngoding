package com.enigmacamp.yukngoding.service;

import com.enigmacamp.yukngoding.entity.Course;
import com.enigmacamp.yukngoding.entity.CourseFee;
import com.enigmacamp.yukngoding.entity.CourseType;
import com.enigmacamp.yukngoding.repository.CourseFeeRepository;
import com.enigmacamp.yukngoding.repository.CourseRepository;
import com.enigmacamp.yukngoding.repository.CourseTypeRepository;

public class MasterCourseServiceImpl implements MasterCourseService {
    private final CourseFeeRepository courseFeeRepository;
    private final CourseTypeRepository courseTypeRepository;
    private final CourseRepository courseRepository;

    public MasterCourseServiceImpl(CourseFeeRepository courseFeeRepository, CourseTypeRepository courseTypeRepository, CourseRepository courseRepository) {
        this.courseFeeRepository = courseFeeRepository;
        this.courseTypeRepository = courseTypeRepository;
        this.courseRepository = courseRepository;
    }

    @Override
    public void createCourseType(CourseType newCourseType) {
        try {
            courseTypeRepository.create(newCourseType);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void createCourseFee(CourseFee newCourseFee) {
        try {
            courseFeeRepository.create(newCourseFee);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void createCourse(Course newCourse) {
        try {
            courseRepository.create(newCourse);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
