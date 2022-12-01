package br.edu.femass.model;

public class Professor extends Leitor{
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

    
}
