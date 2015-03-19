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

    public String getIdTema() {
        return idTema;
    }

    public void setIdTema(String idTema) {
        this.idTema = idTema;
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
        this.listaTema = eliminarTemaController.listaTemas();
    }

    public String process() {
        tema = new Tema();
        tema.setId(Integer.parseInt(getIdTema()));
        eliminarTemaController.removeTema(tema);
        return "home";
    }

}
