package controlles.ejb;

import java.util.List;

import models.daos.DaoFactory;
import models.daos.TemaDao;
import models.daos.VotoDao;
import models.daos.jpa.TemaDaoJpa;
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
    public void SaveVoto(Tema tema, Voto voto) {
        temaDao.create(tema);
        votoDao.create(voto);
    }

    @Override
    public List<Tema> listTema() {
        return temaDao.findAll();
    }

    @Override
    public List<Integer> listValorVoto() {
        for (int i = 0; i < 10; i++) {
            valores.add(i);
        }
        return valores;
    }

    @Override
    public String getPregunta(Tema tema) {
        return TemaDaoJpa.findById(tema.getId()).getPregunta();
    }

}
