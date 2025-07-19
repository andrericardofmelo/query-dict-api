package br.com.pix.query_dict_api.domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Entry {
    @NotBlank
    @Size(min = 11, max = 77)
    private String key;
    @NotBlank
    private KeyType keyType;
    @NotEmpty
    private Account account;
    @NotEmpty
    private Owner owner;
    private String creationDate;
    private String keyOwnershipDate;
    private String openClaimCreationDate;
}
