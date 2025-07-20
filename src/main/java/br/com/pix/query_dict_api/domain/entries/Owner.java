package br.com.pix.query_dict_api.domain.entries;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Owner {
    private OwnerType type;
    @NotBlank
    private String TaxIdNumber;
    @NotBlank
    private String name;
}
