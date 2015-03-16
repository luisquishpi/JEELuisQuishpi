package views.beans;

import org.apache.logging.log4j.LogManager;

import models.daos.DaoFactory;
import models.daos.TemaDao;
import models.daos.jpa.DaoJpaFactory;
import models.entities.Tema;

public class TemaView {
    private Tema tema;
    private TemaDao temaDao;
    
    public TemaView(){
        
    }
    public void setTema(Tema tema) {
        this.tema=tema;
    }
    public Tema getTema(){
       return tema;
    }
    public String process() {
        LogManager.getLogger(TemaView.class).debug(
                    "Se accede a la capa de negocio para registrar persona: " + tema);
        DaoFactory.setFactory(new DaoJpaFactory());
        temaDao = DaoFactory.getFactory().getTemaDao();
        temaDao.create(tema);
        return "home";
    }
}
