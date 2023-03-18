package med.voll.api.request;

import med.voll.api.common.AddressData;
import med.voll.api.enums.Speciality;

public record RegisterADoctorRequest(String name, String email, String crm, Speciality speciality, AddressData addressData) {

}
