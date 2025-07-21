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
public class OwnerLegalPerson extends Owner {
    @NotBlank
    @Pattern(regexp = "[0-9]{14}")
    private String taxIdNumber;
    @NotBlank
    @Pattern(regexp = "^([A-Za-zÀ-ÖØ-öø-ÿ,.@:&*+_<>()!?/\\\\$%\\d' -]+)$")
    private String name;
    @NotBlank
    @Pattern(regexp = "^([A-Za-zÀ-ÖØ-öø-ÿ,.@:&*+_<>()!?/\\\\$%\\d' -]+)$")
    private String tradeName;
}
