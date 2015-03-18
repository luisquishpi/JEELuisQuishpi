package controllers;

import java.util.List;

import models.entities.Tema;
import models.entities.Voto;

public interface VotarController {

    void SaveVoto(Voto voto);

    List<Tema> listaTema();
    Tema findTemaById(int id);

}
