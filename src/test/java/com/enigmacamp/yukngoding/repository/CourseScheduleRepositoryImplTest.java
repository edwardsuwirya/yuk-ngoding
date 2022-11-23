package com.enigmacamp.yukngoding.repository;

import com.enigmacamp.yukngoding.entity.Course;
import com.enigmacamp.yukngoding.entity.CourseFee;
import com.enigmacamp.yukngoding.entity.CourseSchedule;
import com.enigmacamp.yukngoding.entity.CourseType;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

class CourseScheduleRepositoryImplTest extends BaseRepoTest {
    @AfterEach
    void clean() {
        cleanTable("yukngoding.t_course_schedule");
        cleanTable("yukngoding.m_course");
        cleanTable("yukngoding.m_course_type");
        cleanTable("yukngoding.m_course_fee");
        em.clear();
    }

    Course dummyCourse;

    @BeforeEach
    void createCourseScheduleDependencies() {
        clean();
        CourseFee courseFee = new CourseFee();
        courseFee.setId("AAA");
        courseFee.setCourseFeeDescription("Fee");
        CourseFeeRepository courseFeeRepository = new CourseFeeRepositoryImpl(em);
        courseFeeRepository.create(courseFee);

        CourseType courseType = new CourseType();
        courseType.setId("RRR");
        courseType.setTypeName("Type");
        CourseTypeRepository courseTypeRepository = new CourseTypeRepositoryImpl(em);
        courseTypeRepository.create(courseType);

        dummyCourse = new Course();
        dummyCourse.setId("ABC");
        dummyCourse.setCourseName("Dummy Course");
        dummyCourse.setDescription("Dummy description");
        dummyCourse.setDurationInDay(1);
        dummyCourse.setCourseFeeType(courseFee);
        dummyCourse.setCourseType(courseType);
        dummyCourse.setKkm(70);

        CourseRepository courseRepository = new CourseRepositoryImpl(em);
        courseRepository.create(dummyCourse);
    }

    @Test
    void whenCreate_CourseSchedule_Successfully() {
//        Given
        CourseSchedule dummyCourseSchedule = new CourseSchedule();
        dummyCourseSchedule.setCourseCode(dummyCourse);
        dummyCourseSchedule.setStartDate(LocalDate.parse("2020-01-08"));
        dummyCourseSchedule.setEndDate(LocalDate.parse("2020-01-11"));
        dummyCourseSchedule.setStartTime(LocalTime.parse("10:00:00"));
        dummyCourseSchedule.setEndTime(LocalTime.parse("14:00:00"));
        dummyCourseSchedule.setTrainerName("Trainer");
//        When
        CourseScheduleRepository courseScheduleRepository = new CourseScheduleRepositoryImpl(em);
//        Then
        assertDoesNotThrow(() -> courseScheduleRepository.create(dummyCourseSchedule));
    }
}