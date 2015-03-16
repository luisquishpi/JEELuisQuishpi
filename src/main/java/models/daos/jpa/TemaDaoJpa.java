package models.daos.jpa;

import javax.persistence.EntityManager;

import models.daos.TemaDao;
import models.entities.Tema;

public class TemaDaoJpa extends GenericDaoJpa<Tema, Integer> implements TemaDao {

    private Class<Tema> persistentClass;

    public TemaDaoJpa() {
        super(Tema.class);
    }

    public Tema findById(int id) {
        EntityManager entityManager = DaoJpaFactory.getEntityManagerFactory().createEntityManager();
        Tema entity = entityManager.find(persistentClass, id);
        return entity;
    }

}
