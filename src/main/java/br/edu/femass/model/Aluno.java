package br.edu.femass.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class Aluno extends Leitor {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String matricula;

    public Aluno(Long codigo, String nome, String endereco, String telefone, Integer prazoMaximoDevolucao, String matricula) {
        super(codigo, nome, endereco, telefone, prazoMaximoDevolucao);
        this.matricula = matricula;
        setPrazoMaximoDevolucao(15);
    }

    public Aluno() {

    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    @Override
    public String toString() {
        return "Aluno(a): " + this.nome + " | Matrícula: " + this.matricula;
    }
    
}
