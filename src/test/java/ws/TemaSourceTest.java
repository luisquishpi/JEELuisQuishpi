package ws;

import static org.junit.Assert.*;
import models.entities.Tema;

import org.apache.logging.log4j.LogManager;
import org.junit.Before;
import org.junit.Test;

import controllers.ws.WsManager;

public class TemaSourceTest extends ResourceTest {

    private Tema tema1;

    WsManager wsManager;

    @Before
    public void before() {
        this.tema1 = new Tema("Tema test 1", "Pregunta del tema test 1");

    }

    @Test
    public void createTest() {
        LogManager.getLogger(this.getClass()).debug(TemaUris.PATH_TEMAS);
        wsManager = new WsManager(URI, TemaUris.PATH_TEMAS);
        assertTrue(wsManager.create(this.tema1));
        
    }

}
