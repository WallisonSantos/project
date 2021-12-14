package br.com.ser.parcerias.controller;

import javax.persistence.EntityManager;
import br.com.ser.parcerias.model.PessoaDAO;
import br.com.ser.parcerias.model.CategoriaDAO;
import br.com.ser.parcerias.model.ManagerFactoryDAO;

import java.math.BigDecimal;
public class HelloController {
    
    public static void main(String[] args) {
        /**
         * New        -> entra TRANSIENT
         * 
         *    New em uma Entidade (ex.: Entidade Person) vai passar para o estado TRANSIENT, nunca foi persistida, não está gravda no Banco
         *    que não tem um Id, não esta sendo Gerenciada pela JPA
         * 
         * persist()  -> MANAGED
         * 
         *    quando chamamos o método persist(), ela move do estado transient para o estado MANAGED ou gerenciado
         *    MANAGED é o principal estado que uma entidade pode estar, portanto, tudo que acontece com uma entidade nesse estado,
         *    a JPA observará e poderá sincronizar com o banco de dados, a depender do que fizermos.
         * 
         *    Se na linha abaixo do persist() setarmos um nome para outro valor, por exemplo, categoria.setNome("Wallison");
         *    estamos mexendo na entidade, alterando um atributo dela. Como ela está no estado MANAGED, a JPA está olhando isso.
         * 
         * commit()   -> BANCO DE DADOS 
         *     
         *     No estado MANAGED, após termos realizado as alterações, podemos commitar tudo para o BANCO, movendo
         *     esses dados para o Banco 
         * 
         * ou close() -> DETACHED
         * 
         *     A partir do momento em que fechamos o EntityManager, isto é, em.close() ou clear() (para limpar as entidades 
         *     gerenciadas do EntityManager), a categoria muda de estado. Se ela estava salva antes, passa para um estado chamado 
         *     de DETACHED, que é um estado destacado.
         * 
         *     O detached é um estado em que a entidade não é mais transient, porque tem id, já foi salva no banco de dados, porém, 
         *     não está mais sendo gerenciada. Portanto, se mexermos nos atributos, a JPA não disparará update e nem fará mais nada.
         */

        Categoria categoria = new Categoria("PRESIDENTE");
        Person pessoa = new Person("Maria", "26890821332", new BigDecimal("421"), categoria);


        EntityManager entitymanager = ManagerFactoryDAO.getEntityManager();

        PessoaDAO pessoaDAO         = new PessoaDAO(entitymanager);
        CategoriaDAO categoriaDAO   = new CategoriaDAO(entitymanager);


        entitymanager.getTransaction().begin();


        categoriaDAO.cadastrar(categoria);
        pessoaDAO.cadastrar(pessoa);
        

        entitymanager.getTransaction().commit();
        entitymanager.close();


        System.out.println("Criado o Banco de Dados !");
    }
}
