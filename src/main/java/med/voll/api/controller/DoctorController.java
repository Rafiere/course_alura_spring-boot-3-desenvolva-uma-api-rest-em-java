package med.voll.api.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import med.voll.api.entity.Address;
import med.voll.api.entity.Doctor;
import med.voll.api.repository.DoctorRepository;
import med.voll.api.request.RegisterADoctorRequest;
import med.voll.api.response.GetDoctorResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/doctors")
@RequiredArgsConstructor
public class DoctorController {

	private final DoctorRepository repository;

	@PostMapping
	@Transactional //Precisamos ter uma transação ativa para realizarmos a escrita.
	//O "@Valid" diz que o Spring precisa validar o DTO com o Bean Validation.
	public String registerADoctor(@RequestBody @Valid RegisterADoctorRequest request) {

		Address address = Address.of(request.addressData()
		                                    .logradouro(),
		                             request.addressData()
		                                    .bairro(),
		                             request.addressData()
		                                    .cep(),
		                             request.addressData()
		                                    .numero(),
		                             request.addressData()
		                                    .complemento(),
		                             request.addressData()
		                                    .cidade(),
		                             request.addressData()
		                                    .uf());

		Doctor doctor = Doctor.of(request.name(), request.email(), request.crm(), request.telefone(), request.speciality(), address);

		repository.save(doctor);
		return "";
	}

	@GetMapping
	public Page<GetDoctorResponse> listDoctors(Pageable pagination){

		return repository.getDoctors(pagination);
	}
}
