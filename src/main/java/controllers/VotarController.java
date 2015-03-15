package controllers;

import models.entities.Tema;
import models.entities.Voto;

public interface VotarController {

    void SaveVoto(Tema tema,Voto voto);

}
