package br.edu.femass.dao;
import java.util.List;
import br.edu.femass.model.Exemplar;

public class DaoExemplar extends Dao<Exemplar> {
    @SuppressWarnings("unchecked")
    public List<Exemplar> buscar() {
        return em.createQuery("select E from Exemplar E order by E.numero").getResultList();
    }
}
