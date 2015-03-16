package models.daos.jpa;

import javax.persistence.EntityManager;

import models.daos.TemaDao;
import models.entities.Tema;

public class TemaDaoJpa extends GenericDaoJpa<Tema, Integer> implements TemaDao {

    private static Class<Tema> persistentClass;
    static EntityManager entityManager;

    public TemaDaoJpa() {
        super(Tema.class);
        entityManager = DaoJpaFactory.getEntityManagerFactory().createEntityManager();
    }

    public static Tema findById(int id) {
        Tema entity = entityManager.find(persistentClass, id);
        return entity;
    }
}
