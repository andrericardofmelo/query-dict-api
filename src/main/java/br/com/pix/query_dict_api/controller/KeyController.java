package br.com.pix.query_dict_api.controller;

import br.com.pix.query_dict_api.domain.dto.AccountRequest;
import br.com.pix.query_dict_api.domain.dto.GetEntryResponse;
import br.com.pix.query_dict_api.service.EntryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController("/v1/entries")
@Slf4j
public class KeyController {
    @Autowired
    private EntryService entryService;

    @GetMapping(path = "/{key}")
    public Optional<GetEntryResponse> getEntryByKey(@PathVariable final String key) throws Exception {
        log.info("Querying key: {}", key);
        return Optional.ofNullable(entryService.getEntryByKey(key)
                .orElseThrow(() -> new RuntimeException("Key not found: " + key)));
    }

    @GetMapping(path = "/account")
    public List<GetEntryResponse> getEntryListByAccount(@RequestBody final AccountRequest accountRequest) throws Exception {
        log.info("Querying entries by account: {}", accountRequest);
        return entryService.getEntriesByAccount(accountRequest);
    }
}
