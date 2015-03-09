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

public class VotoDaoJpaTest {

    private TemaDao temaDao;

    private Tema tema;

    private VotoDao votoDao;

    private Voto voto;

    @BeforeClass
    public static void beforeClass() {
        DaoFactory.setFactory(new DaoJpaFactory());
        DaoJpaFactory.dropAndCreateTables();
    }

    @Before
    public void before() {
        this.tema = new Tema("Tema1", "Pregunta1");
        temaDao = DaoFactory.getFactory().getTemaDao();
        temaDao.create(tema);

        this.voto = new Voto(tema, "192.168.1.1", NivelEstudio.BACHILLER, 5);
        votoDao = DaoFactory.getFactory().getVotoDao();
        votoDao.create(voto);
        System.out.println("IdVotoBefore: " + voto.getId());
    }

    @Test
    public void testRead() {
        System.out.println("IdVotoRead: " + voto.getId());
        assertEquals(voto, votoDao.read(voto.getId()));
    }

    @Test
    public void testUpdateVoto() {
        voto.setIp("200.90.1.2");
        voto.setValor(8);
        voto.setNivelEstudio(NivelEstudio.INGENIERO);
        votoDao.update(voto);
        assertEquals(voto, votoDao.read(voto.getId()));
    }

    @Test
    public void testDeleteByID() {
        votoDao.deleteById(voto.getId());
        assertNull(votoDao.read(voto.getId()));
    }

    @Test
    public void testFindAll() {
        votoDao.create(new Voto(tema, "192.168.1.2", NivelEstudio.INGENIERO, 2));
        votoDao.create(new Voto(tema, "192.168.1.3", NivelEstudio.BACHILLER, 8));
        assertEquals(3, votoDao.findAll().size());
    }

    @After
    public void after() {
        List<Voto> votos = votoDao.findAll();
        for (Voto v : votos) {
            votoDao.deleteById(v.getId());
        }
    }

}
