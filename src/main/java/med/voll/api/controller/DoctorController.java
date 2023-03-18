package med.voll.api.controller;

import med.voll.api.requests.RegisterADoctorRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

	@PostMapping
	public String registerADoctor(@RequestBody RegisterADoctorRequest request){

		System.out.println(request);
		return "";
	}
}
