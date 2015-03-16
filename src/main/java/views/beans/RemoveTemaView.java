package views.beans;

import java.util.List;

import controllers.EliminarTemaController;
import controlles.ejb.EliminarTemaCotrollerEjb;
import models.daos.TemaDao;
import models.entities.Tema;

public class RemoveTemaView {

    TemaDao temaDao;
    EliminarTemaController eliminarTemaController;

    private List<Tema> listaTema;

    private String errorMsg;

    private Tema tema;

    public RemoveTemaView() {
        eliminarTemaController=new EliminarTemaCotrollerEjb();
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
        this.listaTema = eliminarTemaController.listaTemas();
    }

    public String process() {
        if (!this.tema.getClave().equals("666")) {
            this.errorMsg = "Error en la clave, intente de nuevo"+this.tema.getClave();
            return "removeTema";
        } else {
            eliminarTemaController.removeTema(tema);
            return "home";
        }
    }

}
