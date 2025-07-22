package br.com.pix.query_dict_api.domain.entries;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum OwnerType {
    NATURAL_PERSON("NATURAL_PERSON"),
    LEGAL_PERSON("LEGAL_PERSON");

    private String ownerTypeEnum;
}