package br.com.ser.parcerias.controller;

import javax.persistence.EntityManager;
import br.com.ser.parcerias.model.DataAccessObject;
import br.com.ser.parcerias.model.ManagerFactoryDAO;

import java.math.BigDecimal;
public class HelloController {
    
    public static void main(String[] args) {
              
        Person pessoa = new Person("Wallison", "44232223303", new BigDecimal("800"), Categoria.FUNCIONARIO);

        EntityManager entitymanager = ManagerFactoryDAO.getEntityManager();

        DataAccessObject DAO = new DataAccessObject(entitymanager);



        entitymanager.getTransaction().begin();

        DAO.cadastrar(pessoa);

        entitymanager.getTransaction().commit();

        entitymanager.close();

        System.out.println("Pronto");
    }
}
