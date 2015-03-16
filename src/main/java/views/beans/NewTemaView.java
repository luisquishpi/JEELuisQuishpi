package views.beans;

import models.daos.DaoFactory;
import models.daos.TemaDao;
import models.daos.jpa.DaoJpaFactory;
import models.entities.Tema;

public class NewTemaView {
    private Tema tema;

    private TemaDao temaDao;

    public NewTemaView() {

    }

    public void setTema(Tema tema) {
        this.tema = tema;
    }

    public Tema getTema() {
        return tema;
    }

    public String process() {
        DaoFactory.setFactory(new DaoJpaFactory());
        temaDao = DaoFactory.getFactory().getTemaDao();
        temaDao.create(tema);
        return "home";
    }
}
