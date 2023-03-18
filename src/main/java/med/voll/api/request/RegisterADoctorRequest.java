package med.voll.api.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.common.AddressData;
import med.voll.api.enums.Speciality;

public record RegisterADoctorRequest(
		//O "@NotBlank" verifica se não está nulo e nem vazio. Ele só serve para campos strings.
		@NotBlank String name, @NotBlank @Email String email, @NotBlank String telefone,
		@NotBlank @Pattern(regexp = "\\d{4,6}") String crm, @NotNull Speciality speciality,
		//O "@Valid" diz que o Bean Validation precisa validar o DTO "AddressData".
		@NotNull @Valid AddressData addressData) {

}
