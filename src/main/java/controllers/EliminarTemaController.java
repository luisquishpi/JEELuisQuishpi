package controllers;

import java.util.List;

import models.entities.Tema;

public interface EliminarTemaController {

    void removeTema(Tema tema);
    List<Tema> listaTemas();
}
