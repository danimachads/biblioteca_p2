package br.edu.femass.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  //codigo
    private String titulo;
    @ManyToOne
    private Autor autor;
    
    public Livro(String titulo, Autor autor) {
        this.titulo = titulo;
        this.autor = autor;
        //this.codigo = codigo;
    }

    public Livro() {

    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Long getId() {
        return id;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

     public Autor getAutor() {
        return autor;
    }

    @Override
    public String toString() {
        return this.titulo;
    }
}
