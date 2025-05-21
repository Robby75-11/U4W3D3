package entities;

import enumeration.TipoStudente;
import jakarta.persistence.*;

import java.time.LocalDate;
@Entity //serve al jpa per capire che la classe deve avere una corrispondenza nel database
@Table(name = "studenti") //per dare un nome diverso alla tabella nel database rispetto al nome della classe
public class Studente {
    //@Id serve per rendere il campo primary key nella tabella corrispondente
    @Id
    @GeneratedValue(strategy  = GenerationType.TABLE,generator = "tableGen") // la strategia di default è quella auto che significa
    // che jpa valuterà automaticamente la migliore strategia
    @TableGenerator(name = "tableGen", initialValue = 1, allocationSize = 10)
    /*
    la strategia usata è sequence e c'è bisogno di un'annotazione aggiuntiva per indicare le caratteristich
    della sequenza come valore iniziale e incremento. Il valore dell'attributo generator in GenerateValue
    deve essere
     */
    private int matricola;
    //@Column può essere usato per cambiare il nome del campo nella tabella, per settare il notnull,
    //per rendere il campo unique, per settare la lunghezza del campo
    @Column(length = 20,nullable = false)
    private String nome;
    @Column(length = 20,nullable = false)
    private String cognome;
    @Column(name = "data_nascita")
    private LocalDate dataNascita;
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_studente")
    private TipoStudente tipoStudente;

    public Studente( String nome, String cognome, LocalDate dataNascita, TipoStudente tipoStudente) {
     // this.matricola = matricola;
        this.nome = nome;
        this.cognome = cognome;
        this.dataNascita = dataNascita;
        this.tipoStudente = tipoStudente;
    }

    public int getMatricola() {
        return matricola;
    }

    public void setMatricola(int matricola) {
        this.matricola = matricola;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public LocalDate getDataNascita() {
        return dataNascita;
    }

    public void setDataNascita(LocalDate dataNascita) {
        this.dataNascita = dataNascita;
    }

    public TipoStudente getTipoStudente() {
        return tipoStudente;
    }

    public void setTipoStudente(TipoStudente tipoStudente) {
        this.tipoStudente = tipoStudente;
    }

    @Override
    public String toString() {
        return "Studente{" +
                "matricola=" + matricola +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", dataNascita=" + dataNascita +
                ", tipoStudente=" + tipoStudente +
                '}';
    }
}