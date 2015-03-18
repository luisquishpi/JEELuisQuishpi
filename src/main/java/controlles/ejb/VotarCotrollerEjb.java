package controlles.ejb;

import java.util.List;

import models.daos.DaoFactory;
import models.daos.TemaDao;
import models.daos.VotoDao;
import models.entities.Tema;
import models.entities.Voto;
import controllers.VotarController;

public class VotarCotrollerEjb implements VotarController {

    List<Integer> valores;

    private TemaDao temaDao;

    private VotoDao votoDao;

    public VotarCotrollerEjb() {
        temaDao = DaoFactory.getFactory().getTemaDao();
        votoDao = DaoFactory.getFactory().getVotoDao();
    }

    @Override
    public void SaveVoto(Voto voto) {
        votoDao.create(voto);
    }

    @Override
    public List<Tema> listaTema() {
        return temaDao.findAll();
    }

    @Override
    public Tema findTemaById(int id) {
        return temaDao.read(id);
    }

}
