package controlles.ejb;

import models.daos.DaoFactory;
import models.daos.TemaDao;
import models.daos.jpa.DaoJpaFactory;
import models.entities.Tema;
import controllers.NuevoTemaController;

public class NuevoTemaCotrollerEjb implements NuevoTemaController {

    private TemaDao temaDao;
    @Override
    public void saveTema(Tema tema) {
        DaoFactory.setFactory(new DaoJpaFactory());
        temaDao = DaoFactory.getFactory().getTemaDao();
        temaDao.create(tema);
    }

    @Override
    public boolean existTema(Tema tema) {
        return false;
    }

}
