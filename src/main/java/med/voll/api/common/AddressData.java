package med.voll.api.common;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record AddressData(@NotBlank String logradouro,

                          @NotBlank String bairro,

                          @NotBlank @Pattern(regexp = "\\d{8}") String cep, @NotBlank String uf, String complemento,
                          @NotBlank String cidade, String numero) {

}
