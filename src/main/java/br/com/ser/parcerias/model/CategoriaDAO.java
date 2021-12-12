package br.com.ser.parcerias.model;

import javax.persistence.EntityManager;
import br.com.ser.parcerias.controller.Categoria;

public class CategoriaDAO {

    private EntityManager entitymanager;
    
    // metodo construtor que obriga a instaciação do createEntityManagerFactory da classe Persistence.
    public CategoriaDAO(EntityManager entitymanager) {

        this.entitymanager = entitymanager;
    }



    // Cadastro de Categoria no banco de dados
    public void cadastrar(Categoria categoria) {

        this.entitymanager.persist(categoria);
    }
}