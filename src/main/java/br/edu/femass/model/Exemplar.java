package br.edu.femass.model;
import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Exemplar {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  

    private LocalDate dataAquisicao;

    public Exemplar(LocalDate dataAquisicao) {
        this.dataAquisicao = dataAquisicao;
    }

    public Exemplar() {

    }

    public LocalDate getDataAquisicao() {
        return dataAquisicao;
    }

    public void setDataAquisicao(LocalDate dataAquisicao) {
        this.dataAquisicao = dataAquisicao;
    }

    public Long getId() {
        return id;
    }

}
