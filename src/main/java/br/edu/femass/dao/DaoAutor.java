package br.edu.femass.dao;
import java.util.List;
import br.edu.femass.model.Autor;

public class DaoAutor extends Dao<Autor> {
    @SuppressWarnings("unchecked")
    public List<Autor> buscar() {
        return em.createQuery("select A from Autor A order by A.nome").getResultList();
    }
}
