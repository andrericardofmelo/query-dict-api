package br.com.pix.query_dict_api.service;

import br.com.pix.query_dict_api.domain.entries.KeyType;
import org.springframework.stereotype.Component;

import static br.com.pix.query_dict_api.service.Constants.*;

@Component
public class EntryHelper {

    public KeyType validationKeyType(String key) {
        return switch (getKeyType(key)) {
            case CPF -> {
                if (!key.matches(KEY_REGEX_CPF_PATTERN)) {
                    throw new IllegalArgumentException(INVALID_KEY_FORMAT + key);
                }
                yield KeyType.CPF;
            }
            case CNPJ -> {
                if (!key.matches(KEY_REGEX_CNPJ_PATTERN)) {
                    throw new IllegalArgumentException(INVALID_KEY_FORMAT + key);
                }
                yield KeyType.CNPJ;
            }
            case PHONE -> {
                if (!key.matches(KEY_REGEX_PHONE_PATTERN)) {
                    throw new IllegalArgumentException(INVALID_KEY_FORMAT + key);
                }
                yield KeyType.PHONE;
            }
            case EMAIL -> {
                if (!key.matches(KEY_REGEX_EMAIL_PATTERN)) {
                    throw new IllegalArgumentException(INVALID_KEY_FORMAT + key);
                }
                yield KeyType.EMAIL;
            }
            case EVP -> {
                if (!key.matches(KEY_REGEX_EVP_PATTERN)) {
                    throw new IllegalArgumentException(INVALID_KEY_FORMAT + key);
                }
                yield KeyType.EVP;
            }
            default -> KeyType.INVALID;
        };
    }

    private KeyType getKeyType(String key) {
        if (key.matches(KEY_REGEX_EVP_PATTERN)) {
            return KeyType.EVP;
        } else if (key.matches(KEY_REGEX_CPF_PATTERN)) {
            return KeyType.CPF;
        } else if (key.matches(KEY_REGEX_EMAIL_PATTERN)) {
            return KeyType.EMAIL;
        } else if (key.matches(KEY_REGEX_PHONE_PATTERN)) {
            return KeyType.PHONE;
        } else {
            return KeyType.INVALID;
        }
    }
}
