package br.com.pix.query_dict_api.service;

import br.com.pix.query_dict_api.domain.KeyType;
import br.com.pix.query_dict_api.domain.dto.AccountRequest;
import br.com.pix.query_dict_api.domain.dto.GetEntryResponse;
import br.com.pix.query_dict_api.repo.EntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EntryService {
    @Autowired
    private EntryHelper entryHelper;
    @Autowired
    private AccountHelper accountHelper;
    @Autowired
    private EntryRepository entryRepository;

    public Optional<GetEntryResponse> getEntryByKey(String key) throws Exception {
        if (entryHelper.validationKeyType(key) == KeyType.INVALID) {
            throw new RuntimeException("Invalid key type for key: " + key);
        }
        return Optional.ofNullable(Optional.of(entryRepository.getEntryByKey(key))
                .orElseThrow(() -> new RuntimeException("Key not found: " + key)));
    }

    public List<GetEntryResponse> getEntriesByAccount(AccountRequest accountRequest) throws Exception {
        accountHelper.validationAccount(accountRequest);
        return entryRepository.getEntriesByAccount(accountRequest);
    }
}
