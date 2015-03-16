package views.beans;

import controllers.NuevoTemaController;
import controlles.ejb.NuevoTemaCotrollerEjb;
import models.entities.Tema;

public class NewTemaView {
    private Tema tema;
    

    public NewTemaView() {

    }

    public void setTema(Tema tema) {
        this.tema = tema;
    }

    public Tema getTema() {
        return tema;
    }

    public String process() {
        NuevoTemaController nuevoTemaController=new NuevoTemaCotrollerEjb();
        nuevoTemaController.saveTema(tema);
        return "home";
    }
}
