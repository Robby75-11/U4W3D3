package dao;

import entities.Studente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/*
il dao ha solo una funzione logica, quella di separare la logica di business dalla logica di accesso ai dati
Il dao conterrà tutte le istruzioni per accedere ai dati
La logica di business è la logica che si serve dei dati per prendere decisioni su come proseguire
 */
public class StudenteDao {

    private EntityManager em;

    public StudenteDao(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
        em = emf.createEntityManager();
    }

    //dovrà salvare nel database lo studente che gli viene passato
    public void salva(Studente studente){
        em.getTransaction().begin(); //inizio la transazione

        em.persist(studente);//dico al jpa di salvare lo studente sul database

        em.getTransaction().commit();//il salvataggio effettivo avverrà solo al commit
    }

    /*
    il metodo find serve per chiedere al db uno studente. Il metodo find ha bisogno di 2 parametri di ingresso.
    Il primo rappresenta il nome della classe che dovrà essere restituto, il secondo è la chiave primaria dello
    studente che vogliamo cercare
     */
    public Studente getById(int matricola){
        return em.find(Studente.class,matricola);
    }
    /*
    prende una matricola come parametro. Questa matricola verrà utilizzata per recuperare lo studente dal db
    attraverso il metodo getById che restituisce lo studente se lo trova. Se lo trova lo andiamo a rimuovere
    usando il metodo remove di Entitymanager. Se non lo trova, stampa che non lo ha trovato
     */
    public void rimuovi(int matricola){
        Studente s = getById(matricola);

        if(s!=null){
            em.getTransaction().begin();
            em.remove(s);
            em.getTransaction().commit();
        }
        else{
            System.out.println("Studente con matricola " + matricola+ " non trovato");
        }
    }
}