package com.enigmacamp.yukngoding.repository;

import com.enigmacamp.yukngoding.entity.Trainee;

public interface TraineeRepository {
    void create(Trainee trainee);

    Trainee findOne(Integer id);

    void update(Trainee trainee);
}
