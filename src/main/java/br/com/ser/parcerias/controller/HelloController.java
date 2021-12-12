package br.com.ser.parcerias.controller;

import javax.persistence.EntityManager;
import br.com.ser.parcerias.model.PessoaDAO;
import br.com.ser.parcerias.model.CategoriaDAO;
import br.com.ser.parcerias.model.ManagerFactoryDAO;

import java.math.BigDecimal;
public class HelloController {
    
    public static void main(String[] args) {
        
        Categoria funcionario = new Categoria("FUNCIONARIO");
        Person pessoa = new Person("Wallison", "44232223303", new BigDecimal("800"), funcionario);



        EntityManager entitymanager = ManagerFactoryDAO.getEntityManager();

        PessoaDAO pessoaDAO         = new PessoaDAO(entitymanager);
        CategoriaDAO categoriaDAO   = new CategoriaDAO(entitymanager);

        

        entitymanager.getTransaction().begin();


        categoriaDAO.cadastrar(funcionario);
        pessoaDAO.cadastrar(pessoa);
        

        entitymanager.getTransaction().commit();
        entitymanager.close();

        System.out.println("Criado o Banco de Dados !");
    }
}
