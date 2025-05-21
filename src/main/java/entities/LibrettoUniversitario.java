package entities;

import jakarta.persistence.*;
import jakarta.persistence.Column;
import java.util.Map;

@Embeddable
public class LibrettoUniversitario {

    private String universita;
    private String esame;
    private int voto;

    public LibrettoUniversitario(String universita, String esame, int voto) {
        this.universita = universita;
        this.esame = esame;
        this.voto = voto;
    }

    public void LibrettoUniversitario () {

    }
    public String getUniversita() {
        return universita;
    }

    public void setUniversita(String universita) {
        this.universita = universita;
    }
    public int getVoto() {
        return voto;
    }

    public void setVoto(int voto) {
        this.voto = voto;
    }

    @Override
    public String toString() {
        return "LibrettoUniversitario{" +
                "universita='" + universita + '\'' +
                ", esame='" + esame + '\'' +
                ", voto=" + voto +
                '}';
    }



}
