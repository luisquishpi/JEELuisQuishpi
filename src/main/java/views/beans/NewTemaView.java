package views.beans;

import controllers.NuevoTemaController;
import models.entities.Tema;

public class NewTemaView extends ViewBean {
    private Tema tema;

    private NuevoTemaController nuevoTemaController;

    public NewTemaView() {
        nuevoTemaController = getControllerFactory().getNuevoTemaController();
    }

    public void setTema(Tema tema) {
        this.tema = tema;
    }

    public Tema getTema() {
        return tema;
    }

    public String process() {
        nuevoTemaController.saveTema(tema);
        return "home";
    }
}
