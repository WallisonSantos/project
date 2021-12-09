package br.com.ser.parcerias;


//import javax.swing.text.Document;

import org.bson.Document;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

//import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ParceriasApplication {

	public static void main(String[] args) {
	//	SpringApplication.run(ParceriasApplication.class, args);

		try (MongoClient cliente = new MongoClient("localhost" , 27017)) {
			MongoDatabase bancoDeDados = cliente.getDatabase("test");
			MongoCollection<org.bson.Document> alunos = bancoDeDados.getCollection("alunos");
			Document aluno = (Document) alunos.find().first();
			System.out.println(aluno);
		}
	}

}