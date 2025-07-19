package br.com.pix.query_dict_api.domain;

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

    public int getValue() {
        return switch (this) {
            case CPF -> 1;
            case CNPJ -> 2;
            case PHONE -> 3;
            case EMAIL -> 4;
            case EVP -> 5;
            case INVALID -> 999999;
            default -> throw new IllegalArgumentException("Unknown key type: " + this);
        };
    }
}
