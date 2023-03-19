package med.voll.api.request;

import jakarta.validation.constraints.NotBlank;
import med.voll.api.common.AddressData;

public record UpdateADoctorRequest(@NotBlank String id, String name, String telefone, AddressData addressData) {

}
