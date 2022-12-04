package br.edu.femass.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class Professor extends Leitor{
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private String disciplina;

    public Professor(Long codigo, String nome, String endereco, String telefone, Integer prazoMaximoDevolucao, String disciplina) {
        super(codigo, nome, endereco, telefone, prazoMaximoDevolucao);
        this.disciplina = disciplina;
        setPrazoMaximoDevolucao(30);
    }

    public Professor() {

    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    @Override
    public String toString() {
        return this.nome;
    }    
}
