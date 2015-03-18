package models.daos.jpa;

import javax.persistence.EntityManager;

import models.daos.TemaDao;
import models.entities.Tema;

public class TemaDaoJpa extends GenericDaoJpa<Tema, Integer> implements TemaDao {

    static EntityManager entityManager;

    public TemaDaoJpa() {
        super(Tema.class);
        entityManager = DaoJpaFactory.getEntityManagerFactory().createEntityManager();
    }
}
