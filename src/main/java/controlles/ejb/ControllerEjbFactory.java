package controlles.ejb;

import controllers.ControllerFactory;
import controllers.EliminarTemaController;
import controllers.NuevoTemaController;
import controllers.VerVotacionesController;
import controllers.VotarController;

public class ControllerEjbFactory extends ControllerFactory {

    private VotarController votarController;

    private NuevoTemaController nuevoTemaController;

    @Override
    public VotarController getVotarCotroller() {
        if (votarController == null)
            votarController = new VotarCotrollerEjb();
        return votarController;
    }

    @Override
    public NuevoTemaController getNuevoTemaController() {
        if (nuevoTemaController == null)
            nuevoTemaController = new NuevoTemaCotrollerEjb();
        return nuevoTemaController;
    }

    @Override
    public EliminarTemaController getEliminarTemaController() {
        return null;
    }

    @Override
    public VerVotacionesController getVerVotacionesController() {
        // TODO Auto-generated method stub
        return null;
    }

}
