package views.beans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import controllers.EliminarTemaController;
import models.entities.Tema;

@ManagedBean
@RequestScoped
public class RemoveTemaView extends ViewBean {

    EliminarTemaController eliminarTemaController;

    private List<Tema> listaTema;

    private Tema tema;

    private String idTema;

    private String pregunta;

    private int index;

    public String getPregunta() {
        return pregunta;
    }

    public String getIdTema() {
        return idTema;
    }

    public void setIdTema(String idTema) {
        this.idTema = idTema;
        try {
            this.updatePregunta();
        } catch (Exception e) {
        }
    }

    public RemoveTemaView() {

        eliminarTemaController = getControllerFactory().getEliminarTemaController();
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

    @PostConstruct
    public void update() {
        this.idTema = "0";
        this.listaTema = eliminarTemaController.listaTemas();
        this.updatePregunta();
    }

    public void updatePregunta() {
        index = -1;
        for (int i = 0; i < this.listaTema.size(); i++) {
            Tema t = (Tema) this.listaTema.get(i);
            if (t.getId() == Integer.parseInt(this.idTema))
                index = i;
        }
        if (index != -1)
            this.pregunta = listaTema.get(index).getPregunta();
    }

    public String process() {
        tema = new Tema();
        tema.setId(Integer.parseInt(getIdTema()));
        eliminarTemaController.removeTema(tema);
        return "home";
    }

}
