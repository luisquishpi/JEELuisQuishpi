package views.beans;

import java.util.List;

import controllers.ReportController;

public class ReportView extends ViewBean {

    private List<Object[]> listNumeroVotos;
    private List<Object[]> listVotacionMedia;
    public List<Object[]> getListVotacionMedia() {
        return listVotacionMedia;
    }
    public void setListVotacionMedia(List<Object[]> listVotacionMedia) {
        this.listVotacionMedia = listVotacionMedia;
    }
    private ReportController reportControlller;
    public ReportView(){
        
    }
    public List<Object[]> getListNumeroVotos() {
        return listNumeroVotos;
    }
    public void setListaVotosCadaTema(List<Object[]> listNumeroVotos) {
        this.listNumeroVotos = listNumeroVotos;
    }
    public void update() {
        this.listNumeroVotos = reportControlller.listNumeroVotos();
        this.listVotacionMedia = reportControlller.listVotacionMedia();
    }
}
