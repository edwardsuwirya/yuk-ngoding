package com.enigmacamp.yukngoding.repository;

import com.enigmacamp.yukngoding.entity.CourseFee;

public interface CourseFeeRepository {
    void create(CourseFee courseFee);

    CourseFee findOne(String id);
}
