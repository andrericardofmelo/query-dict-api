package br.com.pix.query_dict_api.service;

import br.com.pix.query_dict_api.domain.dto.AccountRequest;
import br.com.pix.query_dict_api.domain.dto.GetEntryResponse;
import br.com.pix.query_dict_api.domain.entries.KeyType;
import br.com.pix.query_dict_api.exception.InvalidKeyTypeException;
import br.com.pix.query_dict_api.repo.EntriesRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EntryService {

    private final AccountHelper accountHelper;
    private final ValidationHelper validationHelper;
    private final EntriesHelper entriesHelper;
    private final EntriesRepository entriesRepository;


    public EntryService(AccountHelper accountHelper, ValidationHelper validationHelper, EntriesHelper entriesHelper, EntriesRepository entriesRepository) {
        this.accountHelper = accountHelper;
        this.validationHelper = validationHelper;
        this.entriesHelper = entriesHelper;
        this.entriesRepository = entriesRepository;
    }

    private void validateKeyTypeByKey(String key) {
        if (validationHelper.validationKeyType(key) == KeyType.INVALID) {
            throw new InvalidKeyTypeException("The key type is invalid. Please provide a valid key type.");
        }
    }

    public GetEntryResponse getEntryByKey(String key) {
        validateKeyTypeByKey(key);
        return entriesHelper.mountGetEntryResponse(entriesRepository.findEntryByKey(key));
    }

    public List<GetEntryResponse> getEntriesByAccount(AccountRequest accountRequest) {
        accountHelper.validationAccount(accountRequest);
        return new ArrayList<>();
    }
}
