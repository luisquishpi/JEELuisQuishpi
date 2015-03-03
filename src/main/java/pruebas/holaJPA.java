package pruebas;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.eclipse.persistence.config.PersistenceUnitProperties;

public class holaJPA {

    public static void main(String[] args) {
      //Se borrar y se crean las tablas
        Map<String, String> properties = new HashMap<>();
        properties.put(PersistenceUnitProperties.DDL_GENERATION,
                PersistenceUnitProperties.DROP_AND_CREATE);
        EntityManager em = Persistence.createEntityManagerFactory("JEELuisQuishpi", properties)
                .createEntityManager();
        
        User1 u1 = new User1(1, "Nombre usuario1");
        // Create
        em.getTransaction().begin();
        em.persist(u1);
        em.persist(new User1(2, "Soy usuario dos"));
        em.persist(new User1(3, "Soy usuario tres"));
        em.getTransaction().commit();
        // Read
        System.out.println(em.find(User1.class, 1));
        // Update  ---> usuario 2
        em.getTransaction().begin();
        em.merge(new User1(2, "dos cambiado con merge"));
        em.getTransaction().commit();
        // Update2 ---> usuario1
        em.getTransaction().begin();
        u1.setName("uno, cambiado con setName");
        em.getTransaction().commit();
        // Delete
        User1 u3 = em.find(User1.class, 3);
        em.getTransaction().begin();
        em.remove(u3);
        em.getTransaction().commit();
        //Read
        System.out.println(em.find(User1.class, 1));
    }

}
