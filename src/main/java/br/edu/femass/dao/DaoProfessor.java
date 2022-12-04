package br.edu.femass.dao;
import java.util.List;
import br.edu.femass.model.Professor;

public class DaoProfessor extends Dao<Professor> {
    @SuppressWarnings("unchecked")
    public List<Professor> buscar() {
        return em.createQuery("select P from Professor P order by P.id").getResultList();
    }
}
