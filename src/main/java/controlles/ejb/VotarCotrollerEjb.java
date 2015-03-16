package controlles.ejb;

import java.util.List;

import models.daos.DaoFactory;
import models.daos.TemaDao;
import models.daos.VotoDao;
import models.entities.Tema;
import models.entities.Voto;
import models.utils.NivelEstudio;
import controllers.VotarController;

public class VotarCotrollerEjb implements VotarController {

    public VotarCotrollerEjb() {
        temaDao = DaoFactory.getFactory().getTemaDao();
        votoDao = DaoFactory.getFactory().getVotoDao();
    }

    private TemaDao temaDao;
    private VotoDao votoDao;
    @Override
    public void SaveVoto(Tema tema, Voto voto) {
        temaDao.create(tema);
        votoDao.create(voto);
    }

    @Override
    public List<Tema> listTema() {
        return null;
    }

    @Override
    public String getPregunta() {
        return null;
    }

    @Override
    public List<NivelEstudio> listNivelEstudio() {
        return null;
    }

    @Override
    public List<Integer> listValorVoto() {
        return null;
    }

}
