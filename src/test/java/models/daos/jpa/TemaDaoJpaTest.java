package models.daos.jpa;

import static org.junit.Assert.*;

import java.util.List;

import models.daos.DaoFactory;
import models.daos.TemaDao;
import models.daos.VotoDao;
import models.entities.Tema;
import models.entities.Voto;
import models.utils.NivelEstudio;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TemaDaoJpaTest {
    private TemaDao dao;

    private VotoDao votoDao;

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
        votoDao = DaoFactory.getFactory().getVotoDao();
        dao.create(tema);

    }

    @Test
    public void testRead() {
        assertEquals(tema, dao.read(tema.getId()));
    }

    @Test
    public void testUpdateTema() {
        tema.setNombre("other");
        tema.setPregunta("other");
        dao.update(tema);
        assertEquals(tema, dao.read(tema.getId()));
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

    @Test
    public void testDeleteCascade() {
        votoDao.create(new Voto(tema, "192.168.1.1", NivelEstudio.INGENIERO, 2));
        votoDao.create(new Voto(tema, "192.168.1.2", NivelEstudio.BACHILLER, 8));
        dao.deleteById(tema.getId());
    }

    @After
    public void after() {
        List<Tema> temas = dao.findAll();
        for (Tema t : temas) {
            dao.deleteById(t.getId());
        }
    }

}
