package controllers.ws;

import controllers.ControllerFactory;
import controllers.EliminarTemaController;
import controllers.NuevoTemaController;
import controllers.ReportController;
import controllers.VotarController;

public class ControllerWsFactory extends ControllerFactory {

    private VotarController votarController;

    private NuevoTemaController nuevoTemaController;

    private EliminarTemaController eliminarTemaController;

    private ReportController reportController;
    
    @Override
    public VotarController getVotarCotroller() {
        if (votarController == null)
            votarController = new VotarCotrollerWs();
        return votarController;
    }

    @Override
    public ReportController getReportController() {
        if (reportController == null)
            reportController = new ReportCotrollerWs();
        return reportController;
    }

    @Override
    public NuevoTemaController getNuevoTemaController() {
        if (nuevoTemaController == null)
            nuevoTemaController = new NuevoTemaCotrollerWs();
        return nuevoTemaController;
    }

    @Override
    public EliminarTemaController getEliminarTemaController() {
        if (eliminarTemaController == null)
            eliminarTemaController = new EliminarTemaCotrollerWs();
        return eliminarTemaController;
    }

}
