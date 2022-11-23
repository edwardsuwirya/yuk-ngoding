package com.enigmacamp.yukngoding.service;

import com.enigmacamp.yukngoding.entity.CourseSchedule;
import com.enigmacamp.yukngoding.entity.Trainee;
import com.enigmacamp.yukngoding.entity.UserCredential;
import com.enigmacamp.yukngoding.model.CourseEnrollmentRequest;
import com.enigmacamp.yukngoding.repository.CourseScheduleRepository;
import com.enigmacamp.yukngoding.repository.EnrollmentRepository;
import com.enigmacamp.yukngoding.repository.TraineeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class CourseEnrollmentServiceImplTest {

    private EnrollmentRepository enrollmentRepositoryMock;

    private TraineeRepository traineeRepositoryMock;

    private CourseScheduleRepository courseScheduleRepositoryMock;

    @BeforeEach
    void initRepo() {
        courseScheduleRepositoryMock = mock(CourseScheduleRepository.class);
        traineeRepositoryMock = mock(TraineeRepository.class);
        enrollmentRepositoryMock = mock(EnrollmentRepository.class);
    }

    @Test
    void whenEnroll_ActiveUser_Successfully() {
        Trainee dummyTrainee = new Trainee();
        dummyTrainee.setId(1);
        UserCredential userCredential = new UserCredential();
        userCredential.setIsActive(true);
        dummyTrainee.setUserCredential(userCredential);

        CourseSchedule courseSchedule = new CourseSchedule();
        courseSchedule.setId(11);
        List<CourseSchedule> courseScheduleList = new ArrayList<>();
        courseScheduleList.add(courseSchedule);
        CourseEnrollmentService courseEnrollmentService = new CourseEnrollmentServiceImpl(enrollmentRepositoryMock, traineeRepositoryMock, courseScheduleRepositoryMock);
        CourseEnrollmentRequest enrollmentRequest = new CourseEnrollmentRequest();
        enrollmentRequest.setTrainee(dummyTrainee);
        enrollmentRequest.setCourseScheduleList(courseScheduleList);


        when(traineeRepositoryMock.findOne(1)).thenReturn(dummyTrainee);
        when(courseScheduleRepositoryMock.findOne(11)).thenReturn(courseSchedule);
        assertDoesNotThrow(() -> courseEnrollmentService.enroll(enrollmentRequest));
        verify(enrollmentRepositoryMock).bulk(any(List.class));
    }

    @Test
    void whenEnroll_InactiveUser_ThrowException() {
        Trainee dummyTrainee = new Trainee();
        dummyTrainee.setId(1);
        UserCredential userCredential = new UserCredential();
        userCredential.setIsActive(false);
        dummyTrainee.setUserCredential(userCredential);

        CourseSchedule courseSchedule = new CourseSchedule();
        courseSchedule.setId(11);
        List<CourseSchedule> courseScheduleList = new ArrayList<>();
        courseScheduleList.add(courseSchedule);
        CourseEnrollmentService courseEnrollmentService = new CourseEnrollmentServiceImpl(enrollmentRepositoryMock, traineeRepositoryMock, courseScheduleRepositoryMock);
        CourseEnrollmentRequest enrollmentRequest = new CourseEnrollmentRequest();
        enrollmentRequest.setTrainee(dummyTrainee);
        enrollmentRequest.setCourseScheduleList(courseScheduleList);

        when(traineeRepositoryMock.findOne(1)).thenReturn(dummyTrainee);
        when(courseScheduleRepositoryMock.findOne(11)).thenReturn(courseSchedule);
        assertThrows(Exception.class, () -> courseEnrollmentService.enroll(enrollmentRequest));
    }
}