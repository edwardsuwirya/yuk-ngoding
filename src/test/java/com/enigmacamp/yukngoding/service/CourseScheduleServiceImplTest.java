package com.enigmacamp.yukngoding.service;

import com.enigmacamp.yukngoding.entity.Course;
import com.enigmacamp.yukngoding.entity.CourseSchedule;
import com.enigmacamp.yukngoding.model.CourseScheduleRequest;
import com.enigmacamp.yukngoding.repository.CourseRepository;
import com.enigmacamp.yukngoding.repository.CourseScheduleRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

class CourseScheduleServiceImplTest {

    private CourseScheduleRepository courseScheduleRepositoryMock;
    private CourseRepository courseRepositoryMock;

    @BeforeEach
    void initRepo() {
        courseScheduleRepositoryMock = mock(CourseScheduleRepository.class);
        courseRepositoryMock = mock(CourseRepository.class);
    }

    @Test
    void whenRegister_Schedule_Successfully() {
        Course dummyCourse = new Course();
        dummyCourse.setDurationInDay(3);
        when(courseRepositoryMock.findOne(anyString())).thenReturn(dummyCourse);

        doNothing().when(courseScheduleRepositoryMock).create(any(CourseSchedule.class));

        CourseScheduleRequest courseScheduleRequest = new CourseScheduleRequest("ABC", "Dummy trainer", "2022-11-25", "10:00:00", "15:00:00");

        CourseScheduleService courseScheduleService = new CourseScheduleServiceImpl(courseRepositoryMock, courseScheduleRepositoryMock);
        assertDoesNotThrow(() -> courseScheduleService.registration(courseScheduleRequest));
    }
}