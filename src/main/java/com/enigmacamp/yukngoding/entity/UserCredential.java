package com.enigmacamp.yukngoding.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "user_credential", schema = "yukngoding")
public class UserCredential {
    @Id
    @Column(name = "email", nullable = false, length = 100)
    private String id;

    @Column(name = "password", nullable = false, length = 25)
    private String password;

    @Column(name = "is_active", nullable = false)
    private boolean isActive = false;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

}