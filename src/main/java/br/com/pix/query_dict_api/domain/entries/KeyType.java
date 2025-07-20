package br.com.pix.query_dict_api.domain.entries;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum KeyType {
    CPF("CPF"),
    CNPJ("CNPJ"),
    PHONE("PHONE"),
    EMAIL("EMAIL"),
    EVP("EVP"),
    INVALID("INVALID");

    public String keyType;

}
