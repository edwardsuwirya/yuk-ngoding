package com.enigmacamp.yukngoding.model;

import com.enigmacamp.yukngoding.entity.CourseSchedule;
import com.enigmacamp.yukngoding.entity.Trainee;

public class CourseEnrollmentGradingRequest {
    private Trainee trainee;
    private CourseSchedule courseSchedule;

    private int point;

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

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }
}
