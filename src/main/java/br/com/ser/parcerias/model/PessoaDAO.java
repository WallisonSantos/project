package br.com.ser.parcerias.model;

import javax.persistence.EntityManager;
import br.com.ser.parcerias.controller.Person;

public class PessoaDAO {

    private EntityManager entitymanager;

    // metodo construtor que obriga a instaciação do createEntityManagerFactory da classe Persistence.
    public PessoaDAO(EntityManager entitymanager) {

        this.entitymanager = entitymanager;
    }


    // Cadastro de Pessoas no banco de dados
    public void cadastrar(Person pessoa) {

        this.entitymanager.persist(pessoa);
    }
}