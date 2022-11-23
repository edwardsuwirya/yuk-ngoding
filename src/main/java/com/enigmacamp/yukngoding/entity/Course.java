package com.enigmacamp.yukngoding.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "m_course", schema = "yukngoding")
public class Course {
    @Id
    @Column(name = "course_code", nullable = false, length = 7)
    private String id;

    @Column(name = "course_name", nullable = false, length = 100)
    private String courseName;

    @Column(name = "description", length = 250)
    private String description;

    @Column(name = "duration_in_day", nullable = false)
    private Integer durationInDay;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "course_fee_type", nullable = false)
    private CourseFee courseFeeType;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "course_type", nullable = false)
    private CourseType courseType;

    @Column(name = "kkm", nullable = false)
    private Integer kkm;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getDurationInDay() {
        return durationInDay;
    }

    public void setDurationInDay(Integer durationInDay) {
        this.durationInDay = durationInDay;
    }

    public CourseFee getCourseFeeType() {
        return courseFeeType;
    }

    public void setCourseFeeType(CourseFee courseFeeType) {
        this.courseFeeType = courseFeeType;
    }

    public CourseType getCourseType() {
        return courseType;
    }

    public void setCourseType(CourseType courseType) {
        this.courseType = courseType;
    }

    public Integer getKkm() {
        return kkm;
    }

    public void setKkm(Integer kkm) {
        this.kkm = kkm;
    }

}