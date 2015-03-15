package controllers;

import java.util.List;

import models.entities.Tema;
import models.entities.Voto;
import models.utils.NivelEstudio;

public interface VotarController {

    void SaveVoto(Tema tema, Voto voto);

    List<Tema> listTema();

    String getPregunta();

    List<NivelEstudio> listNivelEstudio();

    List<Integer> listValorVoto();

}
