package med.voll.api.entities;

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
}
