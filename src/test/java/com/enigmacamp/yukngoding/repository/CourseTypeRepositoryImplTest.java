package com.enigmacamp.yukngoding.repository;

import com.enigmacamp.yukngoding.entity.CourseType;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CourseTypeRepositoryImplTest extends BaseRepoTest {

    @BeforeEach
    @AfterEach
    void clean() {
        cleanTable("yukngoding.m_course_type");
        em.clear();
    }

    @Test
    void whenCreate_NameTooLong_ThrowException() {
//        Given
        CourseType dummyCourseType = new CourseType();
        dummyCourseType.setId("BE");
        dummyCourseType.setTypeName("123456789012345678901234567890");
//        When
        CourseTypeRepository courseTypeRepository = new CourseTypeRepositoryImpl(em);
//        Then
        assertThrows(Exception.class, () -> courseTypeRepository.create(dummyCourseType));
    }

    @Test
    void whenCreate_CourseTypeAlreadyExist_ThrowException() {
//        Given
        CourseType dummyCourseType = new CourseType();
        dummyCourseType.setId("BE");
        dummyCourseType.setTypeName("Backend");
//        When
        CourseTypeRepository courseTypeRepository = new CourseTypeRepositoryImpl(em);
        courseTypeRepository.create(dummyCourseType);
        CourseType dummyCourseTypeDuplicate = new CourseType();
        dummyCourseTypeDuplicate.setId("BE");
//        Then
        assertThrows(Exception.class, () -> courseTypeRepository.create(dummyCourseTypeDuplicate));
    }

    @Test
    void whenCreate_CourseType_Successfully() {
//        Given
        CourseType dummyCourseType = new CourseType();
        dummyCourseType.setId("FE");
        dummyCourseType.setTypeName("FrontEnd");
//        When
        CourseTypeRepository courseTypeRepository = new CourseTypeRepositoryImpl(em);
//        Then
        assertDoesNotThrow(() -> courseTypeRepository.create(dummyCourseType));
    }

    @Test
    void whenCreate_CourseMandatoryEmpty_ThrowException() {
//        Given
        CourseType dummyCourseType = new CourseType();
        dummyCourseType.setId(null);
        dummyCourseType.setTypeName(null);
//        When
        CourseTypeRepository courseTypeRepository = new CourseTypeRepositoryImpl(em);
//        Then
        assertThrows(Exception.class, () -> courseTypeRepository.create(dummyCourseType));
    }
}