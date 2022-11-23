package com.enigmacamp.yukngoding.service;

import com.enigmacamp.yukngoding.entity.CourseSchedule;
import com.enigmacamp.yukngoding.entity.Enrollment;
import com.enigmacamp.yukngoding.entity.Trainee;
import com.enigmacamp.yukngoding.model.CourseEnrollmentApprovalRequest;
import com.enigmacamp.yukngoding.model.CourseEnrollmentGradingRequest;
import com.enigmacamp.yukngoding.model.CourseEnrollmentRequest;
import com.enigmacamp.yukngoding.repository.CourseScheduleRepository;
import com.enigmacamp.yukngoding.repository.EnrollmentRepository;
import com.enigmacamp.yukngoding.repository.TraineeRepository;

import java.util.ArrayList;
import java.util.List;

public class CourseEnrollmentServiceImpl implements CourseEnrollmentService {
    private final EnrollmentRepository enrollmentRepository;

    private final TraineeRepository traineeRepository;

    private final CourseScheduleRepository courseScheduleRepository;

    public CourseEnrollmentServiceImpl(EnrollmentRepository enrollmentRepository, TraineeRepository traineeRepository, CourseScheduleRepository courseScheduleRepository) {
        this.enrollmentRepository = enrollmentRepository;
        this.traineeRepository = traineeRepository;
        this.courseScheduleRepository = courseScheduleRepository;
    }

    @Override
    public void enroll(CourseEnrollmentRequest courseEnrollmentRequest) {
        try {
            Trainee trainee = traineeRepository.findOne(courseEnrollmentRequest.getTrainee().getId());
            if (trainee.getUserCredential().getIsActive()) {
                List<Enrollment> enrollments = new ArrayList<>();
                for (CourseSchedule courseSchedule : courseEnrollmentRequest.getCourseScheduleList()) {
                    CourseSchedule schedule = courseScheduleRepository.findOne(courseSchedule.getId());
                    Enrollment enrollment = new Enrollment();
                    enrollment.setTrainee(trainee);
                    enrollment.setSchedule(schedule);
                    enrollments.add(enrollment);
                }

                enrollmentRepository.bulk(enrollments);
            } else {
                throw new RuntimeException("User is not activated");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Override
    public void approveEnrollment(CourseEnrollmentApprovalRequest courseEnrollmentApprovalRequest) {
        Enrollment enrollment = enrollmentRepository.findOne(courseEnrollmentApprovalRequest.getTrainee(), courseEnrollmentApprovalRequest.getCourseSchedule());
        enrollment.setEnrollApproval(true);
        enrollmentRepository.update(enrollment);
    }

    @Override
    public void submitGrade(CourseEnrollmentGradingRequest courseEnrollmentGradingRequest) {
        Enrollment enrollment = enrollmentRepository.findOne(courseEnrollmentGradingRequest.getTrainee(), courseEnrollmentGradingRequest.getCourseSchedule());
        if (enrollment.getEnrollApproval()) {
            enrollment.setGrade(courseEnrollmentGradingRequest.getPoint());
            enrollmentRepository.update(enrollment);
        } else {
            throw new RuntimeException("Enrollment is not approved");
        }

    }
}
