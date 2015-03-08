package models.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name = "Voto.findAll", query = "SELECT v FROM Voto v")
public class Voto implements Serializable {
    private static final long serialVersionUID = 1L;

    public static final String TABLE = "voto";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    public static final String VALOR = "valor";

    private int valor;

    public static final String IP = "ip";

    private String ip;

    public static final String NIVEL_ESTUDIO = "nivelEstudio";

    private String nivelEstudio;

    public static final String ID_TEMA = "idTema";

    private int idTema;

    @ManyToOne
    @JoinColumn(name = "idTema")
    private Tema tema;

    public Voto() {
    }

    public Voto(int valor, String ip, String nivelEstudio, int idTema) {
        this.setValor(valor);
        this.setIp(ip);
        this.setNivelEstudio(nivelEstudio);
        this.setIdTema(idTema);
    }

    public void setIdTema(int idTema) {
        this.idTema = idTema;
    }

    public void setNivelEstudio(String nivelEstudio) {
        this.nivelEstudio = nivelEstudio;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public int getValor() {
        return this.valor;
    }

    public String getIp() {
        return this.ip;
    }

    public String getNivelEstudio() {
        return this.nivelEstudio;
    }

    public int getIdTema() {
        return this.idTema;
    }

    @Override
    public String toString() {
        return "Tema [id=" + id + ", idTema=" + idTema + ", valor=" + valor + ", ip=" + ip
                + ", nivelEstudio=" + nivelEstudio + "]";
    }

    public Tema getTema() {
        return this.tema;
    }

    public void setTema(Tema tema) {
        this.tema = tema;
    }

}
