package med.voll.api.entity;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor //A JPA exige um construtor sem argumentos para as entidades.
@AllArgsConstructor
public class Address {

	private String logradouro;
	private String bairro;
	private String cep;

	private String numero;

	private String complemento;

	private String cidade;

	private String uf;

	public static Address of(String logradouro, String bairro, String cep, String numero, String complemento, String cidade, String uf) {
		return new Address(logradouro, bairro, cep, numero, complemento, cidade, uf);
	}
}
