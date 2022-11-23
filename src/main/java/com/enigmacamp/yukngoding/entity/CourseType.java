package com.enigmacamp.yukngoding.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "m_course_type", schema = "yukngoding")
public class CourseType {
    @Id
    @Column(name = "course_type", nullable = false, length = 3)
    private String id;

    @Column(name = "type_name", nullable = false, length = 25)
    private String typeName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

}