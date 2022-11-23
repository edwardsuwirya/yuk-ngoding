package com.enigmacamp.yukngoding.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "t_enrollment", schema = "yukngoding")
public class Enrollment {
    @EmbeddedId
    private EnrollmentId id;

    public Enrollment() {
        this.id = new EnrollmentId();
    }

    @MapsId("scheduleId")
    @ManyToOne
    @JoinColumn(name = "schedule_id", nullable = false)
    private CourseSchedule schedule;

    @MapsId("traineeId")
    @ManyToOne
    @JoinColumn(name = "trainee_id", nullable = false)
    private Trainee trainee;

    @Column(name = "enroll_approval", nullable = false)
    private Boolean enrollApproval = false;

    @Column(name = "grade", nullable = false)
    private Integer grade = 0;

    public EnrollmentId getId() {
        return id;
    }

    public void setId(EnrollmentId id) {
        this.id = id;
    }

    public CourseSchedule getSchedule() {
        return schedule;
    }

    public void setSchedule(CourseSchedule schedule) {
        this.schedule = schedule;
    }

    public Trainee getTrainee() {
        return trainee;
    }

    public void setTrainee(Trainee trainee) {
        this.trainee = trainee;
    }

    public Boolean getEnrollApproval() {
        return enrollApproval;
    }

    public void setEnrollApproval(Boolean enrollApproval) {
        this.enrollApproval = enrollApproval;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

}