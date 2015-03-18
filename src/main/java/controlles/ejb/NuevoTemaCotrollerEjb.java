package controlles.ejb;

import models.daos.DaoFactory;
import models.daos.TemaDao;
import models.entities.Tema;
import controllers.NuevoTemaController;

public class NuevoTemaCotrollerEjb implements NuevoTemaController {

    private TemaDao temaDao;
    @Override
    public void saveTema(Tema tema) {
        temaDao = DaoFactory.getFactory().getTemaDao();
        temaDao.create(tema);
    }

    @Override
    public boolean existTema(Tema tema) {
        return false;
    }

}
