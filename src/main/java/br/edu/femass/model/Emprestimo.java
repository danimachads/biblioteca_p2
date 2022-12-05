package br.edu.femass.model;
import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Emprestimo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate datEmprestimo;
    private LocalDate dataPrevistaDevolucao;
    private LocalDate dataDevolucao;
    @ManyToOne
    private Exemplar exemplar;
    @ManyToOne
    private Leitor leitor;

    public Emprestimo(Exemplar exemplar, Leitor leitor) {
        this.exemplar = exemplar;
        this.leitor = leitor;
        this.dataPrevistaDevolucao=LocalDate.now().plusDays(leitor.getPrazoMaximoDevolucao());
        this.datEmprestimo=LocalDate.now();
    }

    public Emprestimo() {

    }

    public LocalDate getDatEmprestimo() {
        return datEmprestimo;
    }

    public void setDatEmprestimo(LocalDate datEmprestimo) {
        this.datEmprestimo = datEmprestimo;
    }

    public LocalDate getDataPrevistaDevolucao() {
        return dataPrevistaDevolucao;
    }

    public void setDataPrevistaDevolucao(LocalDate dataPrevistaDevolucao) {
        this.dataPrevistaDevolucao = dataPrevistaDevolucao;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(LocalDate dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public Exemplar getExemplar() {
        return exemplar;
    }

    public void setExemplar(Exemplar exemplar) {
        this.exemplar = exemplar;
    }

    public Leitor getLeitor() {
        return leitor;
    }

    public void setLeitor(Leitor leitor) {
        this.leitor = leitor;
    }

    public void setExemplar(Aluno selectedItem) {
    }

    public void setExemplar(Professor selectedItem) {
    }
}
