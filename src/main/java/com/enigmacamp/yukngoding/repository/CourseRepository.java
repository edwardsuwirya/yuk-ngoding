package com.enigmacamp.yukngoding.repository;

import com.enigmacamp.yukngoding.entity.Course;

public interface CourseRepository {
    void create(Course course);

    Course findOne(String id);
}
