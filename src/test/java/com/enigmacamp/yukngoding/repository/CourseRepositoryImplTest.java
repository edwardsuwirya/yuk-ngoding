package com.enigmacamp.yukngoding.repository;

import com.enigmacamp.yukngoding.entity.Course;
import com.enigmacamp.yukngoding.entity.CourseFee;
import com.enigmacamp.yukngoding.entity.CourseType;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CourseRepositoryImplTest extends BaseRepoTest {
    @AfterEach
    void clean() {
        cleanTable("yukngoding.m_course");
        cleanTable("yukngoding.m_course_fee");
        cleanTable("yukngoding.m_course_type");
        em.clear();
    }

    CourseFee courseFee;
    CourseType courseType;

    @BeforeEach
    void createCourseDependencies() {
        clean();
        courseFee = new CourseFee();
        courseFee.setId("AAA");
        courseFee.setCourseFeeDescription("Fee");
        CourseFeeRepository courseFeeRepository = new CourseFeeRepositoryImpl(em);
        courseFeeRepository.create(courseFee);

        courseType = new CourseType();
        courseType.setId("RRR");
        courseType.setTypeName("Type");
        CourseTypeRepository courseTypeRepository = new CourseTypeRepositoryImpl(em);
        courseTypeRepository.create(courseType);
    }

    @Test
    void whenCreate_Course_Successfully() {
//        Given
        Course dummyCourse = new Course();
        dummyCourse.setId("ABCD");
        dummyCourse.setCourseName("Dummy Course");
        dummyCourse.setDescription("Dummy description");
        dummyCourse.setDurationInDay(1);
        dummyCourse.setCourseFeeType(courseFee);
        dummyCourse.setCourseType(courseType);
        dummyCourse.setKkm(70);

//        When
        CourseRepository courseRepository = new CourseRepositoryImpl(em);
//        Then
        assertDoesNotThrow(() -> courseRepository.create(dummyCourse));
        assertEquals("Type", dummyCourse.getCourseType().getTypeName());
        assertEquals("Fee", dummyCourse.getCourseFeeType().getCourseFeeDescription());
    }
}