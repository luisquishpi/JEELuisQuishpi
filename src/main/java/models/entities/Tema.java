package models.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQuery(name = "Tema.findAll", query = "SELECT t FROM Tema t")
public class Tema implements Serializable{
    private static final long serialVersionUID = 1L;

    public static final String TABLE = "tema";

    public static final String ID = "ID";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    public static final String NOMBRE = "nombre";

    private String nombre;

    public static final String PREGUNTA = "pregunta";

    private String pregunta;

    @OneToMany(mappedBy = TABLE)
    private List<Voto> votos;

    public Tema() {
    }

    public Tema(String nombre, String pregunta) {
        this.setNombre(nombre);
        this.setPregunta(pregunta);
    }

    public Tema(Integer id, String nombre, String pregunta) {
        this.setId(id);
        this.setNombre(nombre);
        this.setPregunta(pregunta);
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getId() {
        return this.id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPregunta() {
        return this.pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    @Override
    public boolean equals(Object obj) {
        assert obj != null;
        Tema other = (Tema) obj;
        return id.equals(other.id) && nombre.equals(other.nombre)
                && pregunta.equals(other.pregunta);
    }

    @Override
    public String toString() {
        return "Tema [id=" + id + ", nombre=" + nombre + ", pregunta=" + pregunta + "]";
    }

    public List<Voto> getVotos() {
        return this.votos;
    }

    public void setVotos(List<Voto> votos) {
        this.votos = votos;
    }

    public Voto addVoto(Voto voto) {
        getVotos().add(voto);
        voto.setTema(this);

        return voto;
    }

    public Voto removeVoto(Voto voto) {
        getVotos().remove(voto);
        voto.setTema(null);

        return voto;
    }
}
