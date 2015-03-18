package models.daos.jpa;

import java.util.List;

import javax.persistence.Query;
import persistence.jpa.JpaFactory;
import models.daos.VotoDao;
import models.entities.Voto;

public class VotoDaoJpa extends GenericDaoJpa<Voto, Integer> implements VotoDao {

    private static Query query;

    public VotoDaoJpa() {
        super(Voto.class);
    }

    @SuppressWarnings("unchecked")
    public static List<Object[]> findNumeroVotos() {
        query = JpaFactory.getEntityManagerFactory().createEntityManager()
                .createNamedQuery(Voto.FIND_NUMERO_VOTOS);
        return query.getResultList();
    }
    @SuppressWarnings("unchecked")
    public static List<Object[]> findVotacionMedia() {
        query = JpaFactory.getEntityManagerFactory().createEntityManager()
                .createNamedQuery(Voto.FIND_VOTACION_MEDIA);
        return  query.getResultList();
    }
}
