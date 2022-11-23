package com.enigmacamp.yukngoding.repository;

import com.enigmacamp.yukngoding.entity.CourseSchedule;
import jakarta.persistence.EntityManager;

public class CourseScheduleRepositoryImpl implements CourseScheduleRepository {
    private final EntityManager em;

    public CourseScheduleRepositoryImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public void create(CourseSchedule courseSchedule) {
        try {
            em.getTransaction().begin();
            em.persist(courseSchedule);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            em.getTransaction().rollback();
            throw new RuntimeException(e);
        }
    }

    @Override
    public CourseSchedule findOne(Integer id) {
        CourseSchedule courseSchedule = em.find(CourseSchedule.class, id);
        if (courseSchedule != null) {
            return courseSchedule;
        }
        throw new RuntimeException("Data not found");
    }
}
