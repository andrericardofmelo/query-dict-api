package br.com.pix.query_dict_api.service;

import br.com.pix.query_dict_api.domain.KeyType;
import org.springframework.stereotype.Component;

@Component
public class EntryHelper {

    private static final String KEY_REGEX_EVP_PATTERN = "^[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}$";
    private static final String KEY_REGEX_CPF_PATTERN = "^[0-9]{11}$";
    private static final String KEY_REGEX_CNPJ_PATTERN = "^[0-9]{14}$";
    private static final String KEY_REGEX_EMAIL_PATTERN = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
    private static final String KEY_REGEX_PHONE_PATTERN = "^\\+[1-9]\\d{1,14}$";

    public KeyType validationKeyType(String key) {
        return switch (getKeyType(key)) {
            case 1 -> {
                if (!key.matches(KEY_REGEX_CPF_PATTERN)) {
                    throw new IllegalArgumentException("Invalid CPF key format: " + key);
                }
                yield KeyType.CPF;
            }
            case 2 -> {
                if (!key.matches(KEY_REGEX_CNPJ_PATTERN)) {
                    throw new IllegalArgumentException("Invalid CNPJ key format: " + key);
                }
                yield KeyType.CNPJ;
            }
            case 3 -> {
                if (!key.matches(KEY_REGEX_PHONE_PATTERN)) {
                    throw new IllegalArgumentException("Invalid Phone key format: " + key);
                }
                yield KeyType.PHONE;
            }
            case 4 -> {
                if (!key.matches(KEY_REGEX_EMAIL_PATTERN)) {
                    throw new IllegalArgumentException("Invalid Email key format: " + key);
                }
                yield KeyType.EMAIL;
            }
            case 5 -> {
                if (!key.matches(KEY_REGEX_EVP_PATTERN)) {
                    throw new IllegalArgumentException("Invalid EVP key format: " + key);
                }
                yield KeyType.EVP;
            }
            default -> KeyType.INVALID;
        };
    }

    private int getKeyType(String key) {
        if (key.matches(KEY_REGEX_EVP_PATTERN)) {
            return KeyType.EVP.getValue();
        } else if (key.matches(KEY_REGEX_CPF_PATTERN)) {
            return KeyType.CPF.getValue();
        } else if (key.matches(KEY_REGEX_EMAIL_PATTERN)) {
            return KeyType.EMAIL.getValue();
        } else if (key.matches(KEY_REGEX_PHONE_PATTERN)) {
            return KeyType.PHONE.getValue();
        } else {
            return KeyType.INVALID.getValue();
        }
    }
}
