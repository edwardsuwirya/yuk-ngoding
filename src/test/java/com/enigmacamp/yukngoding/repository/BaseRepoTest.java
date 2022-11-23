package com.enigmacamp.yukngoding.repository;

import com.enigmacamp.yukngoding.util.JPAUtil;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

public abstract class BaseRepoTest {
    static EntityManager em;

    @BeforeAll
    static void initDb() {
        em = JPAUtil.getEntityManger();
    }

    @AfterAll
    static void closeDb() {
        JPAUtil.shutdown();
    }

    void cleanTable(String tableName){
        em.getTransaction().begin();
        em.createNativeQuery("TRUNCATE TABLE " + tableName + "  CASCADE").executeUpdate();
        em.getTransaction().commit();
    }
}
