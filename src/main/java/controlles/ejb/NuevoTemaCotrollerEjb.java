package controlles.ejb;

import models.entities.Tema;
import controllers.NuevoTemaController;

public class NuevoTemaCotrollerEjb implements NuevoTemaController {

    @Override
    public void saveTema(Tema tema) {
        
    }

    @Override
    public boolean existTema(Tema tema) {
        return false;
    }

}
