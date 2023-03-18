package med.voll.api.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.enums.Speciality;

@Entity
@Getter
@NoArgsConstructor //A JPA exige um construtor sem argumentos para as entidades.
@AllArgsConstructor
@EqualsAndHashCode(of = "id") //A comparação será feita pelo atributo "id".
public class Doctor {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;

	private String nome;

	private String email;

	private String crm;

	@Enumerated(EnumType.STRING)
	private Speciality speciality;

	/* Não teremos uma tabela específica para o "Address", assim, ele ficará em uma classe
	* separada, mas dentro da tabela de "Doctor". */
	@Embedded
	private Address addressData;
}
