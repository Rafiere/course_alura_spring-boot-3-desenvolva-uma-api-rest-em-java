package med.voll.api.repository;

import med.voll.api.entity.Doctor;
import med.voll.api.response.GetDoctorResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DoctorRepository extends JpaRepository<Doctor, String> {

	@Query("SELECT new med.voll.api.response.GetDoctorResponse( " +
	       "d.id, d.name, d.email, d.crm, d.speciality) FROM Doctor d ")
	Page<GetDoctorResponse> getDoctors(Pageable pageable);
}
