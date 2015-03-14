package models.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.ForeignKey;

import models.utils.NivelEstudio;
import models.entities.Tema;

@Entity
@NamedQueries({
        @NamedQuery(name = Voto.FIND_NUMERO_VOTOS, query = "SELECT v.tema, count(v) FROM Voto v LEFT JOIN v.tema t GROUP BY v.tema"),
        @NamedQuery(name = Voto.FIND_VOTACION_MEDIA, query = "SELECT v.nivelEstudio, avg(v.valor) as mediaVoto FROM Voto v GROUP BY v.nivelEstudio"),})
public class Voto implements Serializable {
    private static final long serialVersionUID = 1L;

    public static final String FIND_NUMERO_VOTOS = "findNumeroVotos";

    public static final String FIND_VOTACION_MEDIA = "findVotacionMedia";

    public static final String TABLE = "voto";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    public static final String VALOR = "valor";

    private int valor;

    public static final String IP = "ip";

    private String ip;

    public static final String NIVEL_ESTUDIO = "nivelEstudio";

    private NivelEstudio nivelEstudio;

    public static final String ID_TEMA = "idTema";

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = ID_TEMA, foreignKey = @ForeignKey(name = "FK_VOTO_idTema", foreignKeyDefinition = "FOREIGN KEY (idTema) REFERENCES tema(ID) ON DELETE CASCADE"))
    private Tema tema;

    public Voto() {
    }

    public Voto(Tema tema, String ip, NivelEstudio nivelEstudio, int valor) {
        this.setValor(valor);
        this.setIp(ip);
        this.setNivelEstudio(nivelEstudio);
        this.setTema(tema);
    }

    public void setNivelEstudio(NivelEstudio nivelEstudio) {
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

    public NivelEstudio getNivelEstudio() {
        return this.nivelEstudio;
    }

    @Override
    public boolean equals(Object obj) {
        assert obj != null;
        Voto other = (Voto) obj;
        return id.equals(other.id) && ip.equals(other.ip)
                && nivelEstudio.equals(other.nivelEstudio) && valor == other.valor
                && tema.equals(other.tema);
    }

    @Override
    public String toString() {
        return "Voto [id=" + id + ", Tema=" + tema.toString() + ", valor=" + valor + ", ip=" + ip
                + ", nivelEstudio=" + nivelEstudio + "]";
    }

    public Tema getTema() {
        return this.tema;
    }

    public void setTema(Tema tema) {
        this.tema = tema;
    }

}
