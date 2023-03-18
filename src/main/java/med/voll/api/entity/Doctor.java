package med.voll.api.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.enums.Speciality;

import java.util.UUID;

@Entity
@Getter
@NoArgsConstructor //A JPA exige um construtor sem argumentos para as entidades.
@AllArgsConstructor
@EqualsAndHashCode(of = "id") //A comparação será feita pelo atributo "id".
public class Doctor {

	@Id
	private String id;

	private String name;

	private String email;

	private String telefone;

	private String crm;

	@Enumerated(EnumType.STRING)
	private Speciality speciality;

	/* Não teremos uma tabela específica para o "Address", assim, ele ficará em uma classe
	* separada, mas dentro da tabela de "Doctor". */
	@Embedded
	private Address address;

	public Doctor(String name, String email, String crm, String telefone, Speciality speciality, Address address) {
		this.id = UUID.randomUUID().toString();
		this.name = name;
		this.email = email;
		this.crm = crm;
		this.telefone = telefone;
		this.speciality = speciality;
		this.address = address;
	}

	public static Doctor of(String nome, String email, String crm, String telefone, Speciality speciality, Address address){

		return new Doctor(nome, email, crm, telefone, speciality, address);
	}
}
