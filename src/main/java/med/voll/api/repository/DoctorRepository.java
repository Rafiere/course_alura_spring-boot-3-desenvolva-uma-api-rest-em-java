package med.voll.api.repository;

import med.voll.api.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, String> {

}
