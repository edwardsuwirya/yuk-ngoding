package com.enigmacamp.yukngoding.service;

import com.enigmacamp.yukngoding.entity.Course;
import com.enigmacamp.yukngoding.entity.CourseSchedule;
import com.enigmacamp.yukngoding.model.CourseScheduleRequest;
import com.enigmacamp.yukngoding.repository.CourseRepository;
import com.enigmacamp.yukngoding.repository.CourseScheduleRepository;
import com.enigmacamp.yukngoding.util.DateUtil;

import java.time.LocalDate;
import java.time.LocalTime;

public class CourseScheduleServiceImpl implements CourseScheduleService {
    private final CourseScheduleRepository courseScheduleRepository;
    private final CourseRepository courseRepository;

    public CourseScheduleServiceImpl(CourseRepository courseRepository, CourseScheduleRepository courseScheduleRepository) {
        this.courseScheduleRepository = courseScheduleRepository;
        this.courseRepository = courseRepository;
    }

    @Override
    public void registration(CourseScheduleRequest courseScheduleRequest) {
        try {
            Course course = courseRepository.findOne(courseScheduleRequest.getCourseCode());
            CourseSchedule courseSchedule = new CourseSchedule();
            courseSchedule.setCourseCode(course);
            courseSchedule.setStartTime(LocalTime.parse(courseScheduleRequest.getStartTime()));
            courseSchedule.setEndTime(LocalTime.parse(courseScheduleRequest.getEndTime()));
            courseSchedule.setStartDate(LocalDate.parse(courseScheduleRequest.getStartDate()));

            int duration = course.getDurationInDay();
            LocalDate courseEndDate = DateUtil.periodCalculationWorkDay(courseScheduleRequest.getStartDate(), duration);
            courseSchedule.setEndDate(courseEndDate);
            courseSchedule.setTrainerName(courseScheduleRequest.getTrainerName());
            courseScheduleRepository.create(courseSchedule);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }

}
