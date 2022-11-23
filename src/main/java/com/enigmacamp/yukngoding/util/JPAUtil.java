package com.enigmacamp.yukngoding.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public abstract class JPAUtil {
    private static final String PERSISTENCE_UNIT_NAME = "default";
    private static EntityManagerFactory factory;

    private static void getEntityManagerFactory() {
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
    }

    public static EntityManager getEntityManger() {
        if (factory == null) {
            getEntityManagerFactory();
        }
        return factory.createEntityManager();
    }

    public static void shutdown() {
        if (factory != null) {
            factory.close();
            factory = null;
        }
    }
}
