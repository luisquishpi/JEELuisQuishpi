package views.beans;

import javax.faces.bean.ManagedBean;

import controllers.NuevoTemaController;
import models.entities.Tema;

@ManagedBean
public class NewTemaView extends ViewBean {
    private Tema tema;
    private String nombre;
    private String pregunta;

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

    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }
    public String process() {
        tema=new Tema();
        tema.setNombre(getNombre());
        tema.setPregunta(getPregunta());
        nuevoTemaController.saveTema(tema);
        return "home";
    }

}
