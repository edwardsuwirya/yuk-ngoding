package com.enigmacamp.yukngoding.repository;

import com.enigmacamp.yukngoding.entity.Trainee;
import com.enigmacamp.yukngoding.entity.UserCredential;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

class TraineeRepositoryImplTest extends BaseRepoTest {
    @AfterEach
    @BeforeEach
    void clean() {
        cleanTable("yukngoding.m_trainee");
        cleanTable("yukngoding.user_credential");
        em.clear();
    }

    @Test
    void whenCreate_Trainee_Successfully() {
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
        dummyTrainee.setUserCredential(userCredential);

        TraineeRepository traineeRepository = new TraineeRepositoryImpl(em);
        assertDoesNotThrow(() -> traineeRepository.create(dummyTrainee));
        assertEquals(false, dummyTrainee.getUserCredential().getIsActive());
        assertEquals("12345", dummyTrainee.getUserCredential().getPassword());
        assertEquals("dummy@dummy.net", dummyTrainee.getUserCredential().getId());
    }

    @Test
    void whenUpdate_TraineeActivate_Successfully() {
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
        dummyTrainee.setUserCredential(userCredential);

        TraineeRepository traineeRepository = new TraineeRepositoryImpl(em);
        traineeRepository.create(dummyTrainee);
        dummyTrainee.getUserCredential().setIsActive(true);

        assertDoesNotThrow(() -> traineeRepository.update(dummyTrainee));
        assertEquals(true, dummyTrainee.getUserCredential().getIsActive());
        assertEquals("12345", dummyTrainee.getUserCredential().getPassword());
        assertEquals("dummy@dummy.net", dummyTrainee.getUserCredential().getId());
    }

    @Test
    void whenUpdate_TraineeEnrollment_Successfully() {
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
        dummyTrainee.setUserCredential(userCredential);

        TraineeRepository traineeRepository = new TraineeRepositoryImpl(em);
        traineeRepository.create(dummyTrainee);
        dummyTrainee.getUserCredential().setIsActive(true);
        traineeRepository.update(dummyTrainee);

        assertEquals(true, dummyTrainee.getUserCredential().getIsActive());
        assertEquals("12345", dummyTrainee.getUserCredential().getPassword());
        assertEquals("dummy@dummy.net", dummyTrainee.getUserCredential().getId());
    }
}