package br.com.pix.query_dict_api.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public enum KeyType {
    CPF("CPF"),
    CNPJ("CNPJ"),
    PHONE("PHONE"),
    EMAIL("EMAIL"),
    EVP("EVP");

    private String keyType;
}
