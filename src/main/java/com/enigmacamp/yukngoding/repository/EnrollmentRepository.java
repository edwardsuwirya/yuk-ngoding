package com.enigmacamp.yukngoding.repository;

import com.enigmacamp.yukngoding.entity.CourseSchedule;
import com.enigmacamp.yukngoding.entity.Enrollment;
import com.enigmacamp.yukngoding.entity.Trainee;

import java.util.List;

public interface EnrollmentRepository {
    void bulk(List<Enrollment> enrollmentList);

    Enrollment findOne(Trainee trainee, CourseSchedule courseSchedule);

    void update(Enrollment enrollment);
}
