package com.enigmacamp.yukngoding.service;

import com.enigmacamp.yukngoding.entity.Course;
import com.enigmacamp.yukngoding.entity.CourseFee;
import com.enigmacamp.yukngoding.entity.CourseType;

public interface MasterCourseService {
    void createCourseType(CourseType newCourseType);

    void createCourseFee(CourseFee newCourseFee);

    void createCourse(Course newCourse);
}
