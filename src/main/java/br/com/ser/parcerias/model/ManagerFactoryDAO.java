
/**
 * No JDBC, toda a integração com o banco de dados era feita com uma classe chamada connection, 
 * nós precisávamos abrir uma conexão e, a partir dela, fazer todo o trabalho para acessar o banco de dados.
 * Na JPA, tem algo parecido, que não é bem uma conexão, mas uma interface que faz a ligação do Java com o banco de dados, 
 * que é uma interface chamada EntityManager. Essa classe funciona como se fosse o gerente, o "manager" das entidades, 
 * ou ainda, o gestor das entidades.
 * Toda vez que desejarmos acessar o banco de dados, seja para salvar, excluir, atualizar, carregar, 
 * fazer um select, ou qualquer outra operação que quisermos fazer no banco de dados com a JPA, utilizaremos a interface EntityManager
 * 
 * Para instanciar um EntityManager, em teoria, seria new EntityManager(). Mas, temos um problema: EntityManager não é uma classe, 
 * é uma interface e por isso não podemos dar new, o certo seria dar new numa classe que implementa a interface.
 * Na JPA, não criamos manualmente o EntityManager. NA JPA, o padrão de projeto utilizado é o factory. Assim, existe uma factory 
 * de EntityManager. Para criar EntityManager, precisamos do EntityManagerFactory, ele tem o método que faz a construção do EntityManager.
 *
 * Então, antes de criar o EntityManager, precisamos criar outro objeto, que é o EntityManagerFactory. Nos padrões de projeto, 
 * "design patterns", existe esse padrão de projeto chamado factory, e, há uma factory para isolar a criação do EntityManager.
 * 
 * @Entidades
 * EntityManagerFactory factory = 
 * EntityManager em =
 * 
 * Então, precisamos criar o EntityManagerFactory. Nós temos uma variável EntityManagerFactory e a chamamos de factory. Em teoria, 
 * continuaríamos fazendo new EntityManagerFactory, mas não é assim. Outra classe foi criada na JPA e se chama Persistence, 
 * e ela tem um método estático chamado CreateEntityManagerFactory. Então, basta chamar Persistence.createEntityManagerFactory()
 * 
 * O método CreateEntityManagerFactory está esperando um parâmetro que é uma String. Essa String é o nome do persistence-unit. 
 * Vamos recordar o persistence.xml. Nós tínhamos nele a tag persistence-unit, onde imaginamos que ela fosse como um banco de dados. 
 * Vamos recordar também que, nessa tag, tínahmos o atributo name="cadastro". 
 * Então, é esse nome que passamos para o método CreateEntityManagerFactory.
 * 
 * Se tivéssemos vários bancos de dados na aplicação, teríamos várias tags persistence-unit, cada uma com um name distinto, e, 
 * na hora de criar a factory, passaríamos qual é o persistence-unit. Desta maneira, a JPA fica sabendo com qual banco ela deve se conectar. 
 * Portanto, temos que adicionar o nome do persistence-unit, que, no nosso caso, é "cadastro"
 * 
 */

package br.com.ser.parcerias.model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ManagerFactoryDAO {
    
    // EntityManager é uma interface, então se utiliza a 
    // EntityManagerFactory, porém tbm é uma interface por tanto não implementa a EntityManager, então
    // devemos criar a Factory já com a classe Persistence e o método estático chamado CreateEntityManagerFactory, que irá implementar a EntityManager
    private static final EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("cadastro");

    // Como EntityManager não é uma classe é uma interface, fazemos o get para o método de criação da Entity Manager na classe Persistence.
    public static EntityManager getEntityManager() {

        return FACTORY.createEntityManager();
    }
}

