package com.enigmacamp.yukngoding.repository;

import com.enigmacamp.yukngoding.entity.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

class EnrollmentRepositoryImplTest extends BaseRepoTest {
    @AfterEach
    void clean() {
        cleanTable("yukngoding.t_enrollment");
        cleanTable("yukngoding.m_trainee");
        cleanTable("yukngoding.t_course_schedule");
        cleanTable("yukngoding.m_course_fee");
        cleanTable("yukngoding.m_course_type");
        cleanTable("yukngoding.m_course");
        cleanTable("yukngoding.user_credential");
    }

    CourseSchedule dummyCourseSchedule1;
    CourseSchedule dummyCourseSchedule2;

    Trainee dummyTrainee;

    @BeforeEach
    void createCourseDependencies() {
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

        Course dummyCourse1 = new Course();
        dummyCourse1.setId("ABC");
        dummyCourse1.setCourseName("Dummy Course");
        dummyCourse1.setDescription("Dummy description");
        dummyCourse1.setDurationInDay(1);
        dummyCourse1.setCourseFeeType(courseFee);
        dummyCourse1.setCourseType(courseType);
        dummyCourse1.setKkm(70);

        Course dummyCourse2 = new Course();
        dummyCourse2.setId("XYZ");
        dummyCourse2.setCourseName("Dummy Course 2");
        dummyCourse2.setDescription("Dummy description 2");
        dummyCourse2.setDurationInDay(1);
        dummyCourse2.setCourseFeeType(courseFee);
        dummyCourse2.setCourseType(courseType);
        dummyCourse2.setKkm(70);

        CourseRepository courseRepository = new CourseRepositoryImpl(em);
        courseRepository.create(dummyCourse1);
        courseRepository.create(dummyCourse2);

        dummyCourseSchedule1 = new CourseSchedule();
        dummyCourseSchedule1.setCourseCode(dummyCourse1);
        dummyCourseSchedule1.setStartDate(LocalDate.parse("2020-01-08"));
        dummyCourseSchedule1.setEndDate(LocalDate.parse("2020-01-11"));
        dummyCourseSchedule1.setStartTime(LocalTime.parse("10:00:00"));
        dummyCourseSchedule1.setEndTime(LocalTime.parse("14:00:00"));
        dummyCourseSchedule1.setTrainerName("Trainer");

        dummyCourseSchedule2 = new CourseSchedule();
        dummyCourseSchedule2.setCourseCode(dummyCourse2);
        dummyCourseSchedule2.setStartDate(LocalDate.parse("2020-01-09"));
        dummyCourseSchedule2.setEndDate(LocalDate.parse("2020-01-14"));
        dummyCourseSchedule2.setStartTime(LocalTime.parse("10:00:00"));
        dummyCourseSchedule2.setEndTime(LocalTime.parse("14:00:00"));
        dummyCourseSchedule2.setTrainerName("Trainer");

        CourseScheduleRepository courseScheduleRepository = new CourseScheduleRepositoryImpl(em);
        courseScheduleRepository.create(dummyCourseSchedule1);
        courseScheduleRepository.create(dummyCourseSchedule2);


        dummyTrainee = new Trainee();
        dummyTrainee.setFirstName("dummy name");
        dummyTrainee.setLastName("dummy name");
        dummyTrainee.setNickName("dummy name");
        dummyTrainee.setAddress("dummy address");
        dummyTrainee.setEducation("S10");
        dummyTrainee.setIdCardNo("000000000");
        dummyTrainee.setTelephone("123456789");
        UserCredential userCredential = new UserCredential();
        userCredential.setId("dummy@dummy.net");
        userCredential.setPassword("12345");
        dummyTrainee.setUserCredential(userCredential);

        TraineeRepository traineeRepository = new TraineeRepositoryImpl(em);
        traineeRepository.create(dummyTrainee);
        dummyTrainee.getUserCredential().setIsActive(true);
        traineeRepository.update(dummyTrainee);
    }

    @Test
    void whenCreate_Enrollment_Successfully() {
        EnrollmentRepository enrollmentRepository = new EnrollmentRepositoryImpl(em);
        List<Enrollment> enrollmentList = new ArrayList<>();
        Enrollment enrollment1 = new Enrollment();
        enrollment1.setTrainee(dummyTrainee);
        enrollment1.setSchedule(dummyCourseSchedule1);
        enrollmentList.add(enrollment1);
        Enrollment enrollment2 = new Enrollment();
        enrollment2.setTrainee(dummyTrainee);
        enrollment2.setSchedule(dummyCourseSchedule2);
        enrollmentList.add(enrollment2);

        enrollmentRepository.bulk(enrollmentList);
    }

    @Test
    void whenApprove_Enrollment_Successfully() {
        EnrollmentRepository enrollmentRepository = new EnrollmentRepositoryImpl(em);
        List<Enrollment> enrollmentList = new ArrayList<>();
        Enrollment enrollment1 = new Enrollment();
        enrollment1.setTrainee(dummyTrainee);
        enrollment1.setSchedule(dummyCourseSchedule1);
        enrollmentList.add(enrollment1);
        enrollmentRepository.bulk(enrollmentList);

        Enrollment enrollment = enrollmentRepository.findOne(dummyTrainee, dummyCourseSchedule1);
        enrollment.setEnrollApproval(true);
        enrollmentRepository.update(enrollment);
    }

    @Test
    void whenGrading_Enrollment_Successfully() {
        EnrollmentRepository enrollmentRepository = new EnrollmentRepositoryImpl(em);
        List<Enrollment> enrollmentList = new ArrayList<>();
        Enrollment enrollment1 = new Enrollment();
        enrollment1.setTrainee(dummyTrainee);
        enrollment1.setSchedule(dummyCourseSchedule1);
        enrollmentList.add(enrollment1);
        enrollmentRepository.bulk(enrollmentList);

        Enrollment enrollment = enrollmentRepository.findOne(dummyTrainee, dummyCourseSchedule1);
        enrollment.setEnrollApproval(true);
        enrollment.setGrade(100);
        enrollmentRepository.update(enrollment);
    }
}