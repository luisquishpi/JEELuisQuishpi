package controlles.ejb;

import java.util.List;

import models.daos.jpa.VotoDaoJpa;
import controllers.ReportController;

public class ReportCotrollerEjb implements ReportController {

    public ReportCotrollerEjb() {
        
    }
    @Override
    public List<Object[]> listNumeroVotos() {
        return VotoDaoJpa.findNumeroVotos();
    }

    @Override
    public List<Object[]> listVotacionMedia() {
        return VotoDaoJpa.findVotacionMedia();
    }

}
