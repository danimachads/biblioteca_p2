package br.edu.femass.dao;
import java.util.List;
import br.edu.femass.model.Livro;

public class DaoLivro extends Dao<Livro> {
    @SuppressWarnings("unchecked")
    public List<Livro> buscar() {
        return em.createQuery("select L from Livro L order by L.titulo").getResultList();
    }
}    

