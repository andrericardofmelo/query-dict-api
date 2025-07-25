package br.com.pix.query_dict_api.domain.entries;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OwnerNaturalPerson extends Owner {
    @NotBlank
    @Pattern(regexp = "^\\d{11}$")
    private String taxIdNumber;
    @NotBlank
    @Pattern(regexp = "^([A-Za-zÀ-ÖØ-öø-ÿ' -]+)$")
    private String name;
}
