package com.enigmacamp.yukngoding.service;

import com.enigmacamp.yukngoding.entity.Trainee;
import com.enigmacamp.yukngoding.repository.TraineeRepository;

public class TraineeServiceImpl implements TraineeService {
    private final TraineeRepository traineeRepository;

    public TraineeServiceImpl(TraineeRepository traineeRepository) {
        this.traineeRepository = traineeRepository;
    }

    @Override
    public void registration(Trainee trainee) {
        try {
            traineeRepository.create(trainee);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void activation(Trainee trainee) {
        try {
            Trainee t = traineeRepository.findOne(trainee.getId());
            t.getUserCredential().setIsActive(true);
            traineeRepository.update(trainee);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
