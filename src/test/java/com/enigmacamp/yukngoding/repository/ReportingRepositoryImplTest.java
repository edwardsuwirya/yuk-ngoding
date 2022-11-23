package com.enigmacamp.yukngoding.repository;

import com.enigmacamp.yukngoding.entity.*;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

class ReportingRepositoryImplTest extends BaseRepoTest {
//    @AfterEach
    void clean() {
        cleanTable("yukngoding.t_enrollment");
        cleanTable("yukngoding.m_trainee");
        cleanTable("yukngoding.t_course_schedule");
        cleanTable("yukngoding.m_course_fee");
        cleanTable("yukngoding.m_course_type");
        cleanTable("yukngoding.m_course");
        cleanTable("yukngoding.user_credential");
        cleanTable("yukngoding.t_enrollment");
    }

//    @BeforeEach
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

        CourseRepository courseRepository = new CourseRepositoryImpl(em);
        courseRepository.create(dummyCourse1);

        CourseSchedule dummyCourseSchedule1 = new CourseSchedule();
        dummyCourseSchedule1.setCourseCode(dummyCourse1);
        dummyCourseSchedule1.setStartDate(LocalDate.parse("2020-01-08"));
        dummyCourseSchedule1.setEndDate(LocalDate.parse("2020-01-11"));
        dummyCourseSchedule1.setStartTime(LocalTime.parse("10:00:00"));
        dummyCourseSchedule1.setEndTime(LocalTime.parse("14:00:00"));
        dummyCourseSchedule1.setTrainerName("Trainer");

        CourseScheduleRepository courseScheduleRepository = new CourseScheduleRepositoryImpl(em);
        courseScheduleRepository.create(dummyCourseSchedule1);


        Trainee dummyTrainee = new Trainee();
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
        userCredential.setIsActive(true);
        dummyTrainee.setUserCredential(userCredential);

        Trainee dummyTrainee2 = new Trainee();
        dummyTrainee2.setFirstName("dummy name");
        dummyTrainee2.setLastName("dummy name");
        dummyTrainee2.setNickName("dummy name");
        dummyTrainee2.setAddress("dummy address");
        dummyTrainee2.setEducation("S10");
        dummyTrainee2.setIdCardNo("000000000");
        dummyTrainee2.setTelephone("123456789");
        UserCredential userCredential2 = new UserCredential();
        userCredential2.setId("dummy2@dummy.net");
        userCredential2.setPassword("12345");
        userCredential2.setIsActive(true);
        dummyTrainee2.setUserCredential(userCredential2);

        Trainee dummyTrainee3 = new Trainee();
        dummyTrainee3.setFirstName("dummy name");
        dummyTrainee3.setLastName("dummy name");
        dummyTrainee3.setNickName("dummy name");
        dummyTrainee3.setAddress("dummy address");
        dummyTrainee3.setEducation("S10");
        dummyTrainee3.setIdCardNo("000000000");
        dummyTrainee3.setTelephone("123456789");
        UserCredential userCredential3 = new UserCredential();
        userCredential3.setId("dummy3@dummy.net");
        userCredential3.setPassword("12345");
        userCredential3.setIsActive(true);
        dummyTrainee3.setUserCredential(userCredential3);

        TraineeRepository traineeRepository = new TraineeRepositoryImpl(em);
        traineeRepository.create(dummyTrainee);
        traineeRepository.create(dummyTrainee2);
        traineeRepository.create(dummyTrainee3);

        EnrollmentRepository enrollmentRepository = new EnrollmentRepositoryImpl(em);
        List<Enrollment> enrollmentList = new ArrayList<>();

        Enrollment enrollment1 = new Enrollment();
        enrollment1.setTrainee(dummyTrainee);
        enrollment1.setSchedule(dummyCourseSchedule1);
        enrollment1.setEnrollApproval(true);
        enrollment1.setGrade(50);
        enrollmentList.add(enrollment1);
        Enrollment enrollment2 = new Enrollment();
        enrollment2.setTrainee(dummyTrainee2);
        enrollment2.setSchedule(dummyCourseSchedule1);
        enrollment2.setEnrollApproval(true);
        enrollment2.setGrade(100);
        enrollmentList.add(enrollment2);
        Enrollment enrollment3 = new Enrollment();
        enrollment3.setTrainee(dummyTrainee3);
        enrollment3.setSchedule(dummyCourseSchedule1);
        enrollment3.setEnrollApproval(true);
        enrollment3.setGrade(80);
        enrollmentList.add(enrollment3);

        enrollmentRepository.bulk(enrollmentList);
    }


    @Test
    void averageGradeClass() {
        ReportingRepository repository = new ReportingRepositoryImpl(em);
        double result = repository.averageGradeClass(53);
        System.out.println("===== Average =======");
        System.out.println(result);
    }

    @Test
    void percentageQualifiedTrainee() {
        ReportingRepository repository = new ReportingRepositoryImpl(em);
        double result = repository.percentageQualifiedTrainee(53);
        System.out.println("===== Pct =======");
        System.out.println(result);
    }
}