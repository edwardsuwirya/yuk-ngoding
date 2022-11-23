package com.enigmacamp.yukngoding.repository;

public interface ReportingRepository {
    double averageGradeClass(Integer courseScheduleId);

    double percentageQualifiedTrainee(Integer courseScheduleId);
}
