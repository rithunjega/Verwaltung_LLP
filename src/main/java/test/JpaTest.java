package test;

import noten.NoteModel;
import prozent.Prozent;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaTest {
    private static EntityManager em;

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("verwaltung");
        em = emf.createEntityManager();

        createNoteModel(1L, "PE-A", "12,3,1", "43", "31", "50");
        createNoteModel(2L, "AD", "21,2,12", "3", "16", "12");
    }

    private static void createNoteModel(Long id, String modulname, String mt, String atl, String praesenz, String prozent) {
        em.getTransaction().begin();

        Prozent prozentObj = new Prozent();
        prozentObj.setErreichtLLP(Integer.parseInt(prozent));

        NoteModel noteModel = new NoteModel(id, modulname, mt, atl, praesenz, prozent, prozentObj);

        em.persist(noteModel);
        em.getTransaction().commit();
    }
}