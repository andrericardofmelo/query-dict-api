package br.com.pix.query_dict_api.service;

import br.com.pix.query_dict_api.domain.dto.AccountRequest;
import br.com.pix.query_dict_api.domain.dto.GetEntryResponse;
import br.com.pix.query_dict_api.infra.CacheManager;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EntriesService {

    private final AccountHelper accountHelper;
    private final ValidationHelper validationHelper;
    private final EntriesHelper entriesHelper;
    private final CacheManager repository;

    public EntriesService(AccountHelper accountHelper, ValidationHelper validationHelper, EntriesHelper entriesHelper, CacheManager cacheManager) {
        this.accountHelper = accountHelper;
        this.validationHelper = validationHelper;
        this.entriesHelper = entriesHelper;
        this.repository = cacheManager;
    }

    public GetEntryResponse getEntryByKey(String key) {
        validationHelper.validationKeyType(key);
        return entriesHelper.mountGetEntryResponse(repository.findEntry(key));
    }

    public List<GetEntryResponse> getEntriesByAccount(AccountRequest accountRequest) {
        accountHelper.validationAccount(accountRequest);
        return new ArrayList<>();
    }
}
