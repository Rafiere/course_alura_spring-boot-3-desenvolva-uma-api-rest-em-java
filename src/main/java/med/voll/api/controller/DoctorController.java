package med.voll.api.controller;

import lombok.RequiredArgsConstructor;
import med.voll.api.entity.Address;
import med.voll.api.entity.Doctor;
import med.voll.api.repository.DoctorRepository;
import med.voll.api.request.RegisterADoctorRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/doctors")
@RequiredArgsConstructor
public class DoctorController {

	private final DoctorRepository repository;

	@PostMapping
	public String registerADoctor(@RequestBody RegisterADoctorRequest request) {

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

		Doctor doctor = Doctor.of(request.name(), request.email(), request.crm(), request.speciality(), address);

		repository.save(doctor);
		return "";
	}
}
