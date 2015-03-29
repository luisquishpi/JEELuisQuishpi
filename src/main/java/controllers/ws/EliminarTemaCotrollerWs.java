package controllers.ws;

import java.util.List;

import models.daos.DaoFactory;
import models.daos.TemaDao;
import models.entities.Tema;
import controllers.EliminarTemaController;

public class EliminarTemaCotrollerWs extends ControllerWs implements EliminarTemaController {

    private TemaDao temaDao;

    @Override
    public void removeTema(Tema tema) {
        temaDao = DaoFactory.getFactory().getTemaDao();
        temaDao.deleteById(tema.getId());
    }

    @Override
    public List<Tema> listaTemas() {
        temaDao.findAll();
        return null;
    }

}
