package entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "scuole")
public class Scuola {

    @Id
    @GeneratedValue

    private int id;
    private String nome;

    @OneToMany(mappedBy = "scuola")//il mappedBy serve per indicare chi è il proprietario della relazione
    // e il proprietario è l'altro lato quello che contiene la variabile scuola
    private List<Studente> studenti;

    public Scuola(String nome) {
        this.nome = nome;

    }

    public Scuola(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Studente> getStudenti() {
        return studenti;
    }

    public void setStudenti(List<Studente> studenti) {
        this.studenti = studenti;
    }

    @Override
    public String toString() {
        return "Scuola{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", studenti=" + studenti +
                '}';
    }



}