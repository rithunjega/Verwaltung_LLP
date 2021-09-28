package test;

import model.Score;
import model.Percent;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaTest {

    private static EntityManager em;

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("verwaltung/Hibernate");
        em = emf.createEntityManager();

        createNoteModel(1L, "PE-A", "12,3,1", "43", "31", "50%");
        createNoteModel(2L, "AD", "21,2,12", "3", "16", "12%");
    }

    private static void createNoteModel(Long id, String modulname, String mt, String atl, String praesenz, String prozent) {
        em.getTransaction().begin();

        Percent percentObj = new Percent();
        percentObj.setReachedLLP(Integer.parseInt(prozent));

        Score score = new Score(id, modulname, mt, atl, praesenz, prozent, percentObj);

        em.persist(score);
        em.getTransaction().commit();
    }
}