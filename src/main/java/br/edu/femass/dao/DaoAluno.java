package br.edu.femass.dao;
import java.util.List;
import javax.persistence.Query;
import br.edu.femass.model.Aluno;

public class DaoAluno extends Dao<Aluno> {
    @SuppressWarnings("unchecked")
    public List<Aluno> buscar() {
        Query query = em.createQuery("select A from Aluno A order by A.id");
        return query.getResultList();
    }
}
