package entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "professori")
public class Professore {

    @Id
    @GeneratedValue
    private String nome;
    private int id;
    private String materia;

    @ManyToMany
    private List<Studente> studenti;

    public Professore(String nome, String materia) {
        this.nome = nome;
        this.materia = materia;
    }

    public Professore() {
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

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public List<Studente> getStudenti() {
        return studenti;
    }

    public void setStudenti(List<Studente> studenti) {
        this.studenti = studenti;
    }

    @Override
    public String toString() {
        return "Professore{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", materia='" + materia + '\'' +
                ", studenti=" + studenti +
                '}';
    }
}
