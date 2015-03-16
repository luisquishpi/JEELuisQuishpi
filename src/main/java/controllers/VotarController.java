package controllers;

import java.util.List;

import models.entities.Tema;
import models.entities.Voto;

public interface VotarController {

    void SaveVoto(Tema tema, Voto voto);

    List<Tema> listTema();

    String getPregunta(Tema tema);

    List<Integer> listValorVoto();

}
