package com.enigmacamp.yukngoding.repository;

import com.enigmacamp.yukngoding.entity.Course;
import jakarta.persistence.EntityManager;

public class CourseRepositoryImpl implements CourseRepository {
    private final EntityManager em;

    public CourseRepositoryImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public void create(Course course) {
        try {
            em.getTransaction().begin();
            em.persist(course);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            em.getTransaction().rollback();
            throw new RuntimeException(e);
        }
    }

    @Override
    public Course findOne(String id) {
        Course course = em.find(Course.class, id);
        if (course != null) {
            return course;
        }
        throw new RuntimeException("Data not found");
    }
}
