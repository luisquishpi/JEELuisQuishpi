package views.beans;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import controllers.VotarController;
import models.entities.Tema;
import models.entities.Voto;
import models.utils.NivelEstudio;

@ManagedBean
public class VoteView extends ViewBean {

    private VotarController votarController;

    private List<Tema> listaTema;

    private NivelEstudio[] listaNivelEstudio;

    private Integer[] listaValorVoto;

    private Voto voto;

    private int idTema;

    private int valor;

    private String pregunta;

    private String nivelEstudio;
    private int index;

    public VoteView() {
        votarController = getControllerFactory().getVotarCotroller();
        listaValorVoto = new Integer[11];
        for (int i = 0; i <= 10; i++) {
            listaValorVoto[i] = i;
        }
        this.listaNivelEstudio = NivelEstudio.values();
    }

    public Voto getVoto() {
        return voto;
    }

    public void setVoto(Voto voto) {
        this.voto = voto;
    }

    public List<Tema> getListaTema() {
        return listaTema;
    }

    public void setListaTema(List<Tema> listaTema) {
        this.listaTema = listaTema;
    }

    public NivelEstudio[] getListaNivelEstudio() {
        return listaNivelEstudio;
    }

    public void setListaNivelEstudio(NivelEstudio[] listaNivelEstudio) {
        this.listaNivelEstudio = listaNivelEstudio;
    }

    public Integer[] getListaValorVoto() {
        return listaValorVoto;
    }

    public void setListaValorVoto(Integer[] listaValorVoto) {
        this.listaValorVoto = listaValorVoto;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public String getNivelEstudio() {
        return nivelEstudio;
    }

    public void setNivelEstudio(String nivelEstudio) {
        this.nivelEstudio = nivelEstudio;
    }

    public int getIdTema() {
        return idTema;
    }

    public void setIdTema(int idTema) {
        this.idTema = idTema;
        try {
            this.updatePregunta();
        } catch (Exception e) {
        }
    }

    @PostConstruct
    public void update() {
        this.listaTema = votarController.listaTema();
        this.listaNivelEstudio = this.getListaNivelEstudio();
        this.listaValorVoto = this.getListaValorVoto();
        this.updatePregunta();
    }
    public void updatePregunta() {
        index = -1;
        for (int i = 0; i < this.listaTema.size(); i++) {
            Tema t = (Tema) this.listaTema.get(i);
            if (t.getId() == this.idTema)
                index = i;
        }
        if (index != -1)
            this.pregunta = listaTema.get(index).getPregunta();
    }
    public String process() {
        voto = new Voto();
        String ip = "localhost";
        try {
            ip = InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
        }
        voto.setNivelEstudio(NivelEstudio.valueOf(nivelEstudio));
        voto.setTema(votarController.findTemaById(idTema));
        voto.setValor(valor);
        voto.setIp(ip);
        votarController.SaveVoto(voto);
        return "home";
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

}
