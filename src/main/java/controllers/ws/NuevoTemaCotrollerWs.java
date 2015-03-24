package controllers.ws;

import ws.TemaUris;
import models.entities.Tema;
import controllers.NuevoTemaController;

public class NuevoTemaCotrollerWs extends ControllerWs implements NuevoTemaController {

    private boolean resultado;
    @Override
    public void saveTema(Tema tema) {
        this.setResultado(false);
        this.setResultado(ControllerWs.buildWebServiceManager(TemaUris.PATH_TEMAS,TemaUris.PATH_ID_PARAM)
        .create(tema));
    }
    @Override
    public boolean existTema(Tema tema) {
        return false;
    }

    public boolean isResultado() {
        return resultado;
    }

    public void setResultado(boolean resultado) {
        this.resultado = resultado;
    }

}
