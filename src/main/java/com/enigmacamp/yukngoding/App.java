package com.enigmacamp.yukngoding;

import com.enigmacamp.yukngoding.util.JPAUtil;
import jakarta.persistence.EntityManager;

public class App {
    public static void main(String[] args) {
        EntityManager entityManager = JPAUtil.getEntityManger();
    }
}
