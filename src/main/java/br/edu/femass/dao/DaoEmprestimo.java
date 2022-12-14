package br.edu.femass.dao;
import java.util.List;
import br.edu.femass.model.Emprestimo;

public class DaoEmprestimo extends Dao<Emprestimo> {
    @SuppressWarnings("unchecked")
    public List<Emprestimo> buscar() {
        return em.createQuery("select E from Emprestimo E order by E.id").getResultList();
    }
}
