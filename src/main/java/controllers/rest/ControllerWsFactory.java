package controllers.rest;

import controllers.ControllerFactory;
import controllers.EliminarTemaController;
import controllers.NuevoTemaController;
import controllers.ReportController;
import controllers.VotarController;

public class ControllerWsFactory extends ControllerFactory {

    @Override
    public VotarController getVotarCotroller() {
        return null;
    }

    @Override
    public ReportController getReportController() {
        return null;
    }

    @Override
    public NuevoTemaController getNuevoTemaController() {
        return null;
    }

    @Override
    public EliminarTemaController getEliminarTemaController() {
        return null;
    }

}
