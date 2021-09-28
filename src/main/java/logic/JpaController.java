package logic;

import model.Score;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaController {

    public static EntityManager em;

    public static void startEm() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("verwaltung/Hibernate");
        em = emf.createEntityManager();
    }

    public static void save(Score score) {
        em.getTransaction().begin();
        em.persist(score);
        em.getTransaction().commit();
    }
    public static void delete(Score score) {
        em.getTransaction().begin();
        em.remove(score);
        em.getTransaction().commit();
    }

}
