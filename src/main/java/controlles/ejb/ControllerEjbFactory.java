package controlles.ejb;

import controllers.ControllerFactory;
import controllers.EliminarTemaController;
import controllers.NuevoTemaCotroller;
import controllers.VerVotacionesController;
import controllers.VotarController;

public class ControllerEjbFactory extends ControllerFactory {

    private VotarController votarController;
    @Override
    public VotarController getVotarCotroller() {
        if(votarController==null) votarController=new VotarCotrollerEjb();
        return votarController;
    }

    @Override
    public VerVotacionesController getVerVotacionesController() {
        return null;
    }

    @Override
    public NuevoTemaCotroller getNuevoTemaController() {
        return null;
    }

    @Override
    public EliminarTemaController getEliminarTemaController() {
        return null;
    }

}
