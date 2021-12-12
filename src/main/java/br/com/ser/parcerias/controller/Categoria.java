package br.com.ser.parcerias.controller;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "categorias")
public class Categoria {
    
    /**
     * FUNCIONARIO
     * PRESIDENTE
     * VICE_PRESIDENTE
     * 
     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long   Id;
    private String nome;

    
    // -------------------------------- metodos contrutores ... // 


    public Categoria() {
        super();
    }

    public Categoria(String nome) {
        this.nome = nome;
    }


    // -------------------------------- metodos Getters    ... // 


    public Long getId() {
        return Id;
    }

    public String getNome() {
        return nome;
    }


    // -------------------------------- metodos Setters   ... // 


    public void setId(Long id) {
        this.Id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
