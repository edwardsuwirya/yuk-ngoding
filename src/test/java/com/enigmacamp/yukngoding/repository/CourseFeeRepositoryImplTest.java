package com.enigmacamp.yukngoding.repository;

import com.enigmacamp.yukngoding.entity.CourseFee;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class CourseFeeRepositoryImplTest extends BaseRepoTest {
    @AfterEach
    @BeforeEach
    void clean() {
        cleanTable("yukngoding.m_course_fee");
        em.clear();
    }

    @Test
    void whenCreate_DescriptionTooLong_ThrowException() {
//        Given
        CourseFee dummyCourseFee = new CourseFee();
        dummyCourseFee.setId("PRM");
        dummyCourseFee.setCourseFeeDescription("123456789012345678901234567890");
//        When
        CourseFeeRepository courseFeeRepository = new CourseFeeRepositoryImpl(em);
//        Then
        assertThrows(Exception.class, () -> courseFeeRepository.create(dummyCourseFee));
    }

    @Test
    void whenCreate_CourseFeeAlreadyExist_ThrowException() {
//        Given
        CourseFee dummyCourseFee = new CourseFee();
        dummyCourseFee.setId("PRM");
        dummyCourseFee.setCourseFeeDescription("Premium");
//        When
        CourseFeeRepository courseFeeRepository = new CourseFeeRepositoryImpl(em);
        courseFeeRepository.create(dummyCourseFee);
        CourseFee dummyCourseFeeDuplicate = new CourseFee();
        dummyCourseFeeDuplicate.setId("PRM");
//        Then
        assertThrows(Exception.class, () -> courseFeeRepository.create(dummyCourseFeeDuplicate));
    }

    @Test
    void whenCreate_CourseFee_Successfully() {
//        Given
        CourseFee dummyCourseFee = new CourseFee();
        dummyCourseFee.setId("PRM");
        dummyCourseFee.setCourseFeeDescription("Premium");
//        When
        CourseFeeRepository courseFeeRepository = new CourseFeeRepositoryImpl(em);
//        Then
        assertDoesNotThrow(() -> courseFeeRepository.create(dummyCourseFee));
    }

    @Test
    void whenCreate_CourseFeeMandatoryEmpty_ThrowException() {
//        Given
        CourseFee dummyCourseFee = new CourseFee();
        dummyCourseFee.setId(null);
        dummyCourseFee.setCourseFeeDescription(null);
//        When
        CourseFeeRepository courseFeeRepository = new CourseFeeRepositoryImpl(em);
//        Then
        assertThrows(Exception.class, () -> courseFeeRepository.create(dummyCourseFee));
    }
}