package com.enigmacamp.yukngoding.model;

import com.enigmacamp.yukngoding.entity.CourseSchedule;
import com.enigmacamp.yukngoding.entity.Trainee;

import java.util.List;

public class CourseEnrollmentRequest {
    private Trainee trainee;
    private List<CourseSchedule> courseScheduleList;

    public Trainee getTrainee() {
        return trainee;
    }

    public void setTrainee(Trainee trainee) {
        this.trainee = trainee;
    }

    public List<CourseSchedule> getCourseScheduleList() {
        return courseScheduleList;
    }

    public void setCourseScheduleList(List<CourseSchedule> courseScheduleList) {
        this.courseScheduleList = courseScheduleList;
    }
}
