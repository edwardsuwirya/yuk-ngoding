package com.enigmacamp.yukngoding.model;

import com.enigmacamp.yukngoding.entity.CourseSchedule;
import com.enigmacamp.yukngoding.entity.Trainee;

public class CourseEnrollmentApprovalRequest {
    private Trainee trainee;
    private CourseSchedule courseSchedule;

    public Trainee getTrainee() {
        return trainee;
    }

    public void setTrainee(Trainee trainee) {
        this.trainee = trainee;
    }

    public CourseSchedule getCourseSchedule() {
        return courseSchedule;
    }

    public void setCourseSchedule(CourseSchedule courseSchedule) {
        this.courseSchedule = courseSchedule;
    }
}
