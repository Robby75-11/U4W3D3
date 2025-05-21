import dao.StudenteDao;
import entities.Studente;
import enumeration.TipoStudente;

import java.time.LocalDate;

public class ProvaStudente {

    public static void main(String[] args) {
        StudenteDao dao = new StudenteDao();

        Studente s1 = new Studente("Mario", "Rossi",
                LocalDate.of(2000, 6, 6), TipoStudente.RESIDENTE);

        dao.salva(s1);

    }
}
