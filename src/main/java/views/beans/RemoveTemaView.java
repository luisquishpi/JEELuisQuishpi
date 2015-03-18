package views.beans;

import java.util.List;

import controllers.EliminarTemaController;
import models.entities.Tema;

public class RemoveTemaView extends ViewBean {

    EliminarTemaController eliminarTemaController;

    private List<Tema> listaTema;

    private String errorMsg;

    private Tema tema;

    public RemoveTemaView() {
        eliminarTemaController=getControllerFactory().getEliminarTemaController();
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
            eliminarTemaController.removeTema(tema);
            return "home";
    }

}
