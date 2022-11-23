package com.enigmacamp.yukngoding.repository;

import com.enigmacamp.yukngoding.entity.CourseSchedule;
import com.enigmacamp.yukngoding.entity.Enrollment;
import com.enigmacamp.yukngoding.entity.Trainee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class EnrollmentRepositoryImpl implements EnrollmentRepository {
    private final EntityManager em;

    public EnrollmentRepositoryImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public void bulk(List<Enrollment> enrollmentList) {
        try {
            em.getTransaction().begin();
            for (Enrollment enrollment : enrollmentList) {
                em.persist(enrollment);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            em.getTransaction().rollback();
            throw new RuntimeException(e);
        }
    }

    @Override
    public Enrollment findOne(Trainee trainee, CourseSchedule courseSchedule) {
        TypedQuery<Enrollment> enrollmentTypedQuery = em.createQuery("SELECT e from Enrollment e where e.trainee.id = :traineeId and e.schedule.id = :scheduleId", Enrollment.class);
        enrollmentTypedQuery.setParameter("traineeId", trainee.getId());
        enrollmentTypedQuery.setParameter("scheduleId", courseSchedule.getId());
        return enrollmentTypedQuery.getSingleResult();
    }

    @Override
    public void update(Enrollment enrollment) {
        try {
            em.getTransaction().begin();
            em.merge(enrollment);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            em.getTransaction().rollback();
            throw new RuntimeException(e);
        }
    }
}
