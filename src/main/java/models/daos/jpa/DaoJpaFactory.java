package models.daos.jpa;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.logging.log4j.LogManager;
import org.eclipse.persistence.config.PersistenceUnitProperties;

import models.daos.DaoFactory;
import models.daos.TemaDao;
import models.daos.VotoDao;

public class DaoJpaFactory extends DaoFactory {

    private static final String PERSISTENCE_UNIT = "JEELuisQuishpi";

    private static EntityManagerFactory entityManagerFactory = Persistence
            .createEntityManagerFactory(PERSISTENCE_UNIT);

    public DaoJpaFactory() {
        LogManager.getLogger(DaoJpaFactory.class).debug("create Entity Manager Factory");
    }

    public static void dropAndCreateTables() {
        Map<String, String> properties = new HashMap<>();
        properties.put(PersistenceUnitProperties.DDL_GENERATION,
                PersistenceUnitProperties.DROP_AND_CREATE);
        entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT, properties);
    }

    public static EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }

    @Override
    public TemaDao getTemaDao() {
        return new TemaDaoJpa();
    }

    @Override
    public VotoDao getVotoDao() {
        return new VotoDaoJpa();
    }

}
