package br.com.ser.parcerias.controller;

//import javax.persistence.Column;
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
    private Long   Id;

    // @Column(name = "CPF")

    private String cpf;
    private String nome;
    //private String endereco1;
    //private String endereco2;
    //private String bairro;
    //private String cidade;
    //private String estado;
    //private String cep;
    //private int    idade;
    //private String sexo;
    //private float  peso;
    //private float  altura;


    // -------------------------------- metodos Getters ... // 


    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    // -------------------------------- metodos Setters ... // 

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}