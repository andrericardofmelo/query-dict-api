package br.com.pix.query_dict_api.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Owner {
    private OwnerType ownerType;
    private String taxIdNumber;
    private String name;
    private String tradeName;
}
