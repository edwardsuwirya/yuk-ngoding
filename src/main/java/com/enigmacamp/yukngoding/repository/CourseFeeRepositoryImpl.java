package com.enigmacamp.yukngoding.repository;

import com.enigmacamp.yukngoding.entity.CourseFee;
import jakarta.persistence.EntityManager;

public class CourseFeeRepositoryImpl implements CourseFeeRepository {
    private final EntityManager em;

    public CourseFeeRepositoryImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public void create(CourseFee courseFee) {
        try {
            em.getTransaction().begin();
            em.persist(courseFee);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            em.getTransaction().rollback();
            throw new RuntimeException(e);
        }
    }

    @Override
    public CourseFee findOne(String id) {
        CourseFee courseFee = em.find(CourseFee.class, id);
        if (courseFee != null) {
            return courseFee;
        }
        throw new RuntimeException("Data not found");
    }
}
