package com.enigmacamp.yukngoding.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class EnrollmentId implements Serializable {
    @Column(name = "schedule_id", nullable = false)
    private Integer scheduleId;

    @Column(name = "trainee_id", nullable = false)
    private Integer traineeId;

    public Integer getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(Integer scheduleId) {
        this.scheduleId = scheduleId;
    }

    public Integer getTraineeId() {
        return traineeId;
    }

    public void setTraineeId(Integer traineeId) {
        this.traineeId = traineeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        EnrollmentId entity = (EnrollmentId) o;
        return Objects.equals(this.traineeId, entity.traineeId) &&
                Objects.equals(this.scheduleId, entity.scheduleId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(traineeId, scheduleId);
    }

}