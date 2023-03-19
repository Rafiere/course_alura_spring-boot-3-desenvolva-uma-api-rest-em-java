package med.voll.api.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import med.voll.api.entity.Address;
import med.voll.api.entity.Doctor;
import med.voll.api.repository.DoctorRepository;
import med.voll.api.request.RegisterADoctorRequest;
import med.voll.api.request.UpdateADoctorRequest;
import med.voll.api.response.GetDoctorResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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
	public Void registerADoctor(@RequestBody @Valid RegisterADoctorRequest request) {

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
		return null;
	}

	/* Se o parâmetro "size" não for passado na URL, teremos o "size" igual a "4" registros. */
	@GetMapping
	public Page<GetDoctorResponse> listDoctors(@PageableDefault(size = 4) Pageable pagination){

		return repository.getDoctors(pagination);
	}

	@PutMapping
	@Transactional //Como estamos dentro de uma transação, na JPA, se carregamos a entidade e mudamos
	//um atributo, quando a transação for commitada, ela entenderá que o objeto foi alterado e o salvará
	//automaticamente, assim, não precisamos usar o método "save()".
	public Void updateADoctor(@RequestBody @Valid UpdateADoctorRequest request){

		Doctor doctor = repository.getReferenceById(request.id());

		doctor.update(request.name(), request.telefone(), request.addressData());

		return null;
	}

	@DeleteMapping("{doctorId}")
	@Transactional
	public Void deleteADoctor(@PathVariable String doctorId){

		repository.deleteById(doctorId);

		return null;
	}
}
