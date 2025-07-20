package br.com.pix.query_dict_api.service;

import br.com.pix.query_dict_api.domain.entries.KeyType;
import br.com.pix.query_dict_api.domain.dto.AccountRequest;
import br.com.pix.query_dict_api.domain.dto.GetEntryResponse;
import br.com.pix.query_dict_api.repo.EntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static br.com.pix.query_dict_api.service.Constants.*;

@Service
public class EntryService {

    @Autowired
    private EntryHelper entryHelper;
    @Autowired
    private AccountHelper accountHelper;
    @Autowired
    private EntryRepository entryRepository;

    public Optional<GetEntryResponse> getEntryByKey(String key) throws Exception {
        validateKeyTypeByKey(key);
        return Optional.ofNullable(Optional.of(entryRepository.getEntryByKey(key))
                .orElseThrow(() -> new RuntimeException(KEY_NOT_FOUND + key)));
    }

    private void validateKeyTypeByKey(String key) {
        if (entryHelper.validationKeyType(key) == KeyType.INVALID) {
            throw new RuntimeException(INVALID_KEY_TYPE_FOR_KEY + key);
        }
    }

    public List<GetEntryResponse> getEntriesByAccount(AccountRequest accountRequest) throws Exception {
        accountHelper.validationAccount(accountRequest);
        return entryRepository.getEntriesByAccount(accountRequest);
    }
}
