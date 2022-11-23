package com.enigmacamp.yukngoding.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "m_course_fee", schema = "yukngoding")
public class CourseFee {
    @Id
    @Column(name = "course_fee_type", nullable = false, length = 3)
    private String id;

    @Column(name = "course_fee_description", nullable = false, length = 25)
    private String courseFeeDescription;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCourseFeeDescription() {
        return courseFeeDescription;
    }

    public void setCourseFeeDescription(String courseFeeDescription) {
        this.courseFeeDescription = courseFeeDescription;
    }

}