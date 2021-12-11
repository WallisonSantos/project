package br.com.ser.parcerias.controller;

// import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity //  Uma entidade JPA funciona como um espelho de uma tabela no banco de dados
@Table (name = "pessoas")
public class Person {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long   Id;

    // @Column(name = "CPF")
    private String cpf;
    private String nome;
    private int nascimento;
    private char sexo;
    private float peso;
    private float altura;
    private String endereco;


    // -------------------------------- metodos Getters ... // 

    public float getPeso() {
        return peso;
    }

    public float getAltura() {
        return altura;
    }

    public char getSexo() {
        return sexo;
    }

    public Long getId() {
        return Id;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public int getNascimento() {
        return nascimento;
    }

    public String getNome() {
        return nome;
    }

    // -------------------------------- metodos Setters ... // 

    public void setId(Long id) {
        Id = id;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setNascimento(int nascimento) {
        this.nascimento = nascimento;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }
}
