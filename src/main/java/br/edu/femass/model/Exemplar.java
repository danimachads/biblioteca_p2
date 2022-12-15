package br.edu.femass.model;
import java.sql.Date;
//import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Exemplar {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Livro livro;
    private String numero;
    private Date dataAquisicao;

    public Exemplar(String numero, Date dataAquisicao) {
        this.dataAquisicao = dataAquisicao;
        this.numero = numero;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Exemplar() {

    }

    public Date getDataAquisicao() {
        return dataAquisicao;
    }

    public void setDataAquisicao(Date dataAquisicao) {
        this.dataAquisicao = dataAquisicao;
    }

    public Long getId() {
        return id;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    @Override
    public String toString() {
        return "Exemplar Nº" + this.getNumero() + "do Livro" + this.getLivro().toString();
    }
}
