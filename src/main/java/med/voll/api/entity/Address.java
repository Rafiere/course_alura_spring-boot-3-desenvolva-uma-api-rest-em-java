package med.voll.api.entity;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.common.AddressData;

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

	public void update(AddressData addressData) {

		if(addressData.logradouro() != null){
			this.logradouro = addressData.logradouro();
		}

		if(addressData.bairro() != null){
			this.bairro = addressData.bairro();
		}

		if(addressData.uf() != null){
			this.uf = addressData.uf();
		}

		if(addressData.cidade() != null){
			this.cidade = addressData.cidade();
		}

		if(addressData.numero() != null){
			this.numero = addressData.numero();
		}

		if(addressData.cep() != null){
			this.cep = addressData.cep();
		}

		if(addressData.complemento() != null){
			this.complemento = addressData.complemento();
		}

	}
}
