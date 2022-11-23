package com.enigmacamp.yukngoding.service;

import com.enigmacamp.yukngoding.repository.ReportingRepository;

public class ReportingServiceImpl implements ReportingService {
    private final ReportingRepository repository;

    public ReportingServiceImpl(ReportingRepository repository) {
        this.repository = repository;
    }

    @Override
    public double averageGradeClass(Integer courseScheduleId) {
        return repository.averageGradeClass(courseScheduleId);
    }

    @Override
    public double percentageQualifiedTrainee(Integer courseScheduleId) {
        return repository.percentageQualifiedTrainee(courseScheduleId);
    }
}
