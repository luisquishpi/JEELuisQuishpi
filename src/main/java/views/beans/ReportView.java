package views.beans;

import java.util.List;

import javax.faces.bean.ManagedBean;

import controllers.ReportController;

@ManagedBean
public class ReportView extends ViewBean {

    private ReportController reportControlller;
    private List<Object[]> listNumeroVotos;
    private List<Object[]> listVotacionMedia;
    public List<Object[]> getListVotacionMedia() {
        return listVotacionMedia;
    }
    public void setListVotacionMedia(List<Object[]> listVotacionMedia) {
        this.listVotacionMedia = listVotacionMedia;
    }

    public ReportView(){
        reportControlller=getControllerFactory().getReportController();
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
