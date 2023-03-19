package med.voll.api.response;

import med.voll.api.enums.Speciality;

public record GetDoctorResponse(String id, String name, String email, String crm, Speciality speciality) {

}
