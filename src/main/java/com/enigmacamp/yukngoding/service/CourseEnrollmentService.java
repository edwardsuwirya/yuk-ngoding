package com.enigmacamp.yukngoding.service;

import com.enigmacamp.yukngoding.model.CourseEnrollmentApprovalRequest;
import com.enigmacamp.yukngoding.model.CourseEnrollmentGradingRequest;
import com.enigmacamp.yukngoding.model.CourseEnrollmentRequest;

public interface CourseEnrollmentService {
    void enroll(CourseEnrollmentRequest courseEnrollmentRequest);

    void approveEnrollment(CourseEnrollmentApprovalRequest courseEnrollmentApprovalRequest);

    void submitGrade(CourseEnrollmentGradingRequest courseEnrollmentGradingRequest);
}
