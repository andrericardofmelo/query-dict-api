package br.com.pix.query_dict_api.domain.entries;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Owner {
    private OwnerType type;
    @NotBlank
    private String taxIdNumber;
    @NotBlank
    private String name;
}
