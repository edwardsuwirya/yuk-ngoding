package com.enigmacamp.yukngoding.repository;

import com.enigmacamp.yukngoding.entity.CourseSchedule;

public interface CourseScheduleRepository {
    void create(CourseSchedule courseSchedule);
    CourseSchedule findOne(Integer id);
}
