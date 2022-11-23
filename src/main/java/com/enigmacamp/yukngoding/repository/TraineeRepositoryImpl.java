package com.enigmacamp.yukngoding.repository;

import com.enigmacamp.yukngoding.entity.Trainee;
import jakarta.persistence.EntityManager;

public class TraineeRepositoryImpl implements TraineeRepository {
    private final EntityManager em;

    public TraineeRepositoryImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public void create(Trainee trainee) {
        try {
            em.getTransaction().begin();
            em.persist(trainee);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            em.getTransaction().rollback();
            throw new RuntimeException(e);
        }
    }

    @Override
    public Trainee findOne(Integer id) {
        Trainee trainee = em.find(Trainee.class, id);
        if (trainee != null) {
            return trainee;
        }
        throw new RuntimeException("Data not found");
    }

    @Override
    public void update(Trainee trainee) {
        try {
            em.getTransaction().begin();
            em.merge(trainee);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            em.getTransaction().rollback();
            throw new RuntimeException(e);
        }
    }
}
