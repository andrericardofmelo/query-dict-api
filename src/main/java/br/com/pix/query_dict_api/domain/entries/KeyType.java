package br.com.pix.query_dict_api.domain.entries;

import br.com.pix.query_dict_api.exception.InvalidKeyTypeException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.regex.Pattern;

import static br.com.pix.query_dict_api.infra.Constants.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum KeyType {
    CPF(KEY_REGEX_CPF_PATTERN),
    CNPJ(KEY_REGEX_CNPJ_PATTERN),
    PHONE(KEY_REGEX_PHONE_PATTERN),
    EMAIL(KEY_REGEX_EMAIL_PATTERN),
    EVP(KEY_REGEX_EVP_PATTERN),
    INVALID(" ");

    private Pattern pattern;

    KeyType(String regex) {
        this.pattern = (regex != null) ? Pattern.compile(regex) : null;
    }

    public boolean matches(String key) {
        return pattern != null && pattern.matcher(key).matches();
    }

    public void validate(String key) {
        if (!matches(key)) {
            throw new InvalidKeyTypeException("Invalid key format: " + key);
        }
    }

    public static KeyType from(String key) {
        return Arrays.stream(values())
                .filter(type -> type != INVALID && type.matches(key))
                .findFirst()
                .orElse(INVALID);
    }
}
