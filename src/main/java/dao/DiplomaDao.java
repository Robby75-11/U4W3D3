package dao;

import entities.Diploma;
import entities.Studente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class DiplomaDao {

    private EntityManager em;

    public DiplomaDao(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
        em = emf.createEntityManager();
    }


    public void salva(Diploma diploma){
        em.getTransaction().begin(); //inizio la transazione

        em.persist(diploma);

        em.getTransaction().commit();//il salvataggio effettivo avverrà solo al commit
    }


    public Diploma getById(int id){
        return em.find(Diploma.class,id);
    }

    public void rimuovi(int id){
        Diploma d = getById(id);

        if(d!=null){
            em.getTransaction().begin();
            em.remove(d);
            em.getTransaction().commit();
        }
        else{
            System.out.println("Diploma con id " + id+ " non trovato");
        }
    }
}