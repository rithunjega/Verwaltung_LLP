package test;

import model.Score;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JpaControllerTest {

    private static EntityManager em;

    @BeforeAll
    public static void setup() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("verwaltung/Hibernate");
        em = emf.createEntityManager();
        em.getTransaction().begin();
    }

    @Test
    public void testCreate() {
        Score score = new Score();
        score.setId(1L);
        score.setModulname("PF-A");
        score.setMt("12");
        score.setAtl("2");
        score.setPresence("4");
        score.setPercent("50%");

        assertEquals(1L ,em.find(Score.class, score.getId()));
    }

    @Test
    public void testDelete() {
        Long id = 1L;
        Score score = em.find(Score.class, id);
        em.remove(score);

        assertEquals(null ,em.find(Score.class, score.getId()));
    }

    @Test
    public void save(Score score) {
        em.persist(score);
        em.getTransaction().commit();

        assertEquals(score ,em.find(Score.class, score));
    }
}