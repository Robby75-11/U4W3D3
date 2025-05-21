package dao;
import entities.Diploma;
import entities.Scuola;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ScuolaDao {

    private EntityManager em;

    public ScuolaDao(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
        em = emf.createEntityManager();
    }


    public void salva(Scuola scuola){
        em.getTransaction().begin(); //inizio la transazione

        em.persist(scuola);

        em.getTransaction().commit();//il salvataggio effettivo avverrà solo al commit
    }


    public Scuola getById(int id){
        return em.find(Scuola.class,id);
    }

    public void rimuovi(int id){
        Scuola scuola = getById(id);

        if(scuola!=null){
            em.getTransaction().begin();
            em.remove(scuola);
            em.getTransaction().commit();
        }
        else{
            System.out.println("Scuola con id " + id+ " non trovata");
        }
    }

}
