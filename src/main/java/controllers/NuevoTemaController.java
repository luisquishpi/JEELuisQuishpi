package controllers;

import models.entities.Tema;

public interface NuevoTemaController {

    void saveTema(Tema tema);
    boolean existTema(Tema tema);
}
