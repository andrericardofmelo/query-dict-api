package br.com.pix.query_dict_api.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Entry {
    private String key;
    private KeyType keyType;
    private Account account;
    private Owner owner;
    private String creationDate;
    private String keyOwnershipDate;
    private String openClaimCreationDate;
}
