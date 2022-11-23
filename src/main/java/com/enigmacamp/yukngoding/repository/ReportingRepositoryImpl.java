package com.enigmacamp.yukngoding.repository;

import com.enigmacamp.yukngoding.entity.Enrollment;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class ReportingRepositoryImpl implements ReportingRepository {
    private final EntityManager entityManager;

    public ReportingRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public double averageGradeClass(Integer courseScheduleId) {
        String sql = "select avg(e.grade) from Enrollment e where e.schedule.id=:scheduleId";
        Query query = entityManager.createQuery(sql);
        query.setParameter("scheduleId", courseScheduleId);
        return (double) query.getSingleResult();
    }

    @Override
    public double percentageQualifiedTrainee(Integer courseScheduleId) {
        String sql = "select e from Enrollment e where e.schedule.id=:scheduleId";
        TypedQuery<Enrollment> query = entityManager.createQuery(sql, Enrollment.class);
        query.setParameter("scheduleId", courseScheduleId);

        List<Enrollment> enrollmentList = query.getResultList();
        Enrollment enrollment = enrollmentList.get(0);
        Integer kkm = enrollment.getSchedule().getCourseCode().getKkm();
        int totalTrainee = enrollmentList.size();
        int qualified = 0;
        for (Enrollment e : enrollmentList) {
            if (e.getGrade() > kkm) {
                qualified++;
            }
        }
        return ((double) qualified / (double) totalTrainee) * 100;
    }
}
