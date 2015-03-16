package controlles.ejb;

import java.util.List;

import models.daos.DaoFactory;
import models.daos.TemaDao;
import models.daos.jpa.DaoJpaFactory;
import models.entities.Tema;
import controllers.EliminarTemaController;

public class EliminarTemaCotrollerEjb implements EliminarTemaController {

    private TemaDao temaDao;
    
    @Override
    public void removeTema(Tema tema) {
        DaoFactory.setFactory(new DaoJpaFactory());
        temaDao = DaoFactory.getFactory().getTemaDao();
        temaDao.deleteById(tema.getId());
    }

    @Override
    public List<Tema> listaTemas() {
        DaoFactory.setFactory(new DaoJpaFactory());
        temaDao = DaoFactory.getFactory().getTemaDao();
        return temaDao.findAll();
    }

}
