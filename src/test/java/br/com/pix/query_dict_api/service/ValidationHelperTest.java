package br.com.pix.query_dict_api.service;

import br.com.pix.query_dict_api.domain.entries.KeyType;
import br.com.pix.query_dict_api.exception.InvalidKeyTypeException;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ValidationHelperTest {

    private final ValidationHelper validationHelper = new ValidationHelper();

    @Test
    void testIsValidationKeyTypeExist() {
        assertEquals(KeyType.CPF, validationHelper.validationKeyType("12345678909"));
        assertEquals(KeyType.CNPJ, validationHelper.validationKeyType("12345678000195"));
        assertEquals(KeyType.PHONE, validationHelper.validationKeyType("+5511999999999"));
        assertEquals(KeyType.EMAIL, validationHelper.validationKeyType("mariaoli@gmail.com"));
        assertEquals(KeyType.EVP, validationHelper.validationKeyType("123e4567-e89b-12d3-a456-426614174000"));
    }
    @Test
    void testValidationKeyTypeWithInvalidFormat() {
        assertThatThrownBy(() -> validationHelper.validationKeyType("1234567890123456789012345678901234567890"))
                .isInstanceOf(InvalidKeyTypeException.class)
                .hasMessage("Invalid key format: 1234567890123456789012345678901234567890"
        );
    }

}
