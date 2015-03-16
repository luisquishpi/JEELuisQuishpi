package views.beans;

import java.util.List;
import models.daos.DaoFactory;
import models.daos.TemaDao;
import models.daos.jpa.DaoJpaFactory;
import models.entities.Tema;

public class RemoveTemaView {

    private TemaDao temaDao;

    private List<Tema> listaTema;

    private String errorMsg;

    private Tema tema;

    public RemoveTemaView() {

    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public List<Tema> getListaTema() {
        return listaTema;
    }

    public void setListaTema(List<Tema> listaTema) {
        this.listaTema = listaTema;
    }

    public Tema getTema() {
        return tema;
    }

    public void setTema(Tema tema) {
        this.tema = tema;
    }

    public void update() {
        DaoFactory.setFactory(new DaoJpaFactory());
        temaDao = DaoFactory.getFactory().getTemaDao();
        this.listaTema = temaDao.findAll();
        System.out.println(this.listaTema);
    }

    public String process() {
        if (!this.tema.getClave().equals("666")) {
            this.errorMsg = "Error en la clave, intente de nuevo"+this.tema.getClave();
            return "removeTema";
        } else {
            System.out.println("Id a remover: "+tema.getId());
            DaoFactory.setFactory(new DaoJpaFactory());
            temaDao = DaoFactory.getFactory().getTemaDao();
            temaDao.deleteById(tema.getId());
            return "home";
        }
    }

}
