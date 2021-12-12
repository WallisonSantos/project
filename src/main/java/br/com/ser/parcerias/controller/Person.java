package br.com.ser.parcerias.controller;

/**
 * Não utilizados:
 * import javax.persistence.EnumType;
 * import javax.persistence.Enumerated;
 */

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity //  Uma entidade JPA funciona como um espelho de uma tabela no banco de dados
@Table (name = "tbPessoas")
public class Person {

    /**
     * mapear enum pela ordem das constantes é algo arriscado. O ideal é mapear pelo nome da constante.
     * Significa que não queremos que a coluna seja do tipo inteiro e sim um texto, um varchar, e que ele insira a constante 
     * FUNCIONARIO, PRESIDENTE, VICE_PRESIDENTE, de maneira independente da ordem declarada na constante. Sendo assim, se alguém altera a ordem, nada muda no banco de dados.
     * Para ensinar isso à JPA, que não é mais o padrão, em cima do atributo Categoria, na classe Produto.java, colocaremos a anotação @Enumerated()
     * @Enumerated (EnumType.STRING)
     *
     * @ManyToOne - Cardinalidade dos relacionamentos entre tabelas (Para a classe Categoria)
     * Desta maneira, temos a obrigação de dizer à JPA qual é a cardinalidade desse relacionamento. Se um produto tem uma única categoria 
     * ou várias categorias, é um para um, um para muitos, muitos para um, ou seja, qual é a cardinalidade. Se observarmos o desenho 
     * do diagrama, veremos que, de produtos para categorias, temos: muitos para um. Isto é, um produto tem uma única categoria, mas 
     * uma categoria pode estar vinculada a vários produtos.
     * 
     * Então, de produtos para categorias: asterisco, 1. Que quer dizer: muitos para um. Na JPA, para informarmos que a cardinalidade 
     * desse relacionamento é "muitos para um", temos uma anotação, @ManyToOne. Ou seja, muitos produtos estão vinculados com uma Categoria. 
     * Uma categoria pode ter vários produtos, mas o produto tem uma única categoria.
     */
    @ManyToOne
    private Categoria     categoria;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long          Id;
    
    @Column(name = "data_cadastro")
    private LocalDateTime dataAtual = LocalDateTime.now();
       
    private String        cpf;
    private String        nome;
    private BigDecimal    taxa;


    // -------------------------------- metodos contrutores ... // 


    public Person() {
        super();
    }


    public Person(String nome, String cpf, BigDecimal taxa, Categoria categoria){
        super();
        this.cpf        = cpf;
        this.nome       = nome;
        this.taxa       = taxa;
        this.categoria  = categoria;
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
        return categoria;
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

    public void setCat(Categoria categoria) {
        this.categoria = categoria;
    }
}