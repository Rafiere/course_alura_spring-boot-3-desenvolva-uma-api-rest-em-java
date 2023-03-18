package med.voll.api.requests;

import med.voll.api.common.Address;
import med.voll.api.enums.Speciality;

public record RegisterADoctorRequest(String name, String email, String crm, Speciality speciality, Address address) {

}
