package com.enigmacamp.yukngoding.model;

public class CourseScheduleRequest {
    private String courseCode;
    private String trainerName;
    private String startDate;
    private String startTime;
    private String endTime;

    public CourseScheduleRequest(String courseCode, String trainerName, String startDate, String startTime, String endTime) {
        this.courseCode = courseCode;
        this.trainerName = trainerName;
        this.startDate = startDate;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getTrainerName() {
        return trainerName;
    }

    public void setTrainerName(String trainerName) {
        this.trainerName = trainerName;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}
