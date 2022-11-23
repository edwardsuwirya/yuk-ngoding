package com.enigmacamp.yukngoding.repository;

import com.enigmacamp.yukngoding.entity.CourseType;
import jakarta.persistence.EntityManager;

public class CourseTypeRepositoryImpl implements CourseTypeRepository {
    private final EntityManager em;

    public CourseTypeRepositoryImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public void create(CourseType courseType) {
        try {
            em.getTransaction().begin();
            em.persist(courseType);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            em.getTransaction().rollback();
            throw new RuntimeException(e);
        }
    }
}
