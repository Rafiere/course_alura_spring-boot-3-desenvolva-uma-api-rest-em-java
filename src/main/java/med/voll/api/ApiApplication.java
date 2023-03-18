package med.voll.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiApplication {

	/* Essa é a classe que utilizamos para executar o projeto. */

	/* Por padrão, o Spring Boot já insere o servidor de aplicação, que é o Tomcat, dentro do
	* projeto. O Spring comum não adicionada o servidor de aplicação. */
	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}

}
