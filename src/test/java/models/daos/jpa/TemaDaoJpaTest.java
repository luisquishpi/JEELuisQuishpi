package models.daos.jpa;

import static org.junit.Assert.*;
import models.daos.DaoFactory;
import models.daos.TemaDao;
import models.entities.Tema;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import persistence.jpa.JpaFactory;

public class TemaDaoJpaTest {
    private TemaDao dao;

    private Tema tema;

    @BeforeClass
    public static void beforeClass() {
        DaoFactory.setFactory(new DaoJpaFactory());
        DaoJpaFactory.dropAndCreateTables();
    }

    @Before
    public void before() {
        this.tema = new Tema("Sistemas", "Pregunta1");
        dao = DaoFactory.getFactory().getTemaDao();
        dao.create(tema);
    }

    @Test
    public void testRead() {
        assertEquals(tema, dao.read(tema.getId()));
    }

    @Test
    public void testUpdateCategory() {
        tema.setNombre("other");
        tema.setPregunta("other");
        dao.update(tema);
    }

    @Test
    public void testDeleteByID() {
        dao.deleteById(tema.getId());
        assertNull(dao.read(tema.getId()));
    }

    @Test
    public void testFindAll() {
        dao.create(new Tema("2", "2"));
        dao.create(new Tema("3", "3"));
        assertEquals(3, dao.findAll().size());
    }

    @After
    public void after() {
        JpaFactory.dropAndCreateTables();
    }

}
