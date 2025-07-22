package br.com.pix.query_dict_api.service;

import br.com.pix.query_dict_api.domain.entries.KeyType;
import br.com.pix.query_dict_api.exception.EntriesNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class ValidationHelper {
    public KeyType validationKeyType(String key) {
        if (key == null || key.isEmpty()) {
            throw new EntriesNotFoundException("The key cannot be null or empty.");
        }
        KeyType keyType = KeyType.from(key);
        keyType.validate(key);
        return keyType;
    }
}
