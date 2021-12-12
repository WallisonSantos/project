package br.com.ser.parcerias.controller;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity //  Uma entidade JPA funciona como um espelho de uma tabela no banco de dados
@Table (name = "tbPessoas")
public class Person {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long          Id;
    private String        cpf;
    private String        nome;
    private BigDecimal    taxa;    
    private Categoria     cat;
    
    @Column(name = "data_cadastro")
    private LocalDateTime dataAtual = LocalDateTime.now();
    
    //private Date     nascimento;
    
    // -------------------------------- metodos contrutores ... // 


    public Person() {
        super();
    }


    public Person(String nome, String cpf, BigDecimal taxa, Categoria categoria){
        super();
        this.cpf        = cpf;
        this.nome       = nome;
        this.taxa       = taxa;
        this.cat        = categoria;
        // this.nascimento = nascimento;
    }


    // -------------------------------- metodos Getters ... // 


    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public LocalDateTime getDataAtual() {
        return dataAtual;
    }

    public Long getId() {
        return Id;
    }

    public BigDecimal getTaxa() {
        return taxa;
    }

    public Categoria getCat() {
        return cat;
    }


    // -------------------------------- metodos Setters ... // 


    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDataAtual(LocalDateTime dataAtual) {
        this.dataAtual = dataAtual;
    }

    public void setId(Long id) {
        Id = id;
    }

    public void setTaxa(BigDecimal taxa) {
        this.taxa = taxa;
    }

    public void setCat(Categoria cat) {
        this.cat = cat;
    }
}