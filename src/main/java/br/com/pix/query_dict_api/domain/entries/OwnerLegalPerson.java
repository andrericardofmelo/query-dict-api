package br.com.pix.query_dict_api.domain.entries;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OwnerLegalPerson extends Owner {
    @NotBlank
    @Pattern(regexp = "\\d{14}")
    private String taxIdNumber;
    @NotBlank
    @Pattern(regexp = "^([A-Za-zÀ-ÖØ-öø-ÿ,.@:&*+_<>()!?/\\\\$%\\d' -]+)$")
    private String name;
    @NotBlank
    @Pattern(regexp = "^([A-Za-zÀ-ÖØ-öø-ÿ,.@:&*+_<>()!?/\\\\$%\\d' -]+)$")
    private String tradeName;
}
