package med.voll.api.requests;

import med.voll.api.common.AddressData;
import med.voll.api.enums.Speciality;

public record RegisterADoctorRequest(String name, String email, String crm, Speciality speciality, AddressData addressData) {

}
