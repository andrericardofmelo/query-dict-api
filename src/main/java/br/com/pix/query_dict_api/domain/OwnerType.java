package br.com.pix.query_dict_api.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public enum OwnerType {
    NATURAL_PERSON("NATURAL_PERSON"),
    LEGAL_ENTITY("LEGAL_ENTITY");

    private String ownerType;
}