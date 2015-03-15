package controllers;

import models.entities.Tema;

public interface NuevoTemaCotroller {

    void saveTema(Tema tema);
    boolean existTema(Tema tema);
}
