package br.com.ser.parcerias.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HelloController {
    
    public static void main(String[] args) {
        
        Person pessoa = new Person();

        pessoa.setCpf("123.432.123-10");
        pessoa.setEndereco("Rua Um");
        pessoa.setNascimento("15/08/1996");
        pessoa.setNome("Wallison");

        // Factoring - que tem o método que faz a construção
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("parcerias");

        // Gestor do Banco de Dados
        EntityManager em = factory.createEntityManager();
        em.persist(pessoa);
    }
    
}
