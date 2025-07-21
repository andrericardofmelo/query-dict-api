package br.com.pix.query_dict_api.controller;

import br.com.pix.query_dict_api.domain.dto.AccountRequest;
import br.com.pix.query_dict_api.domain.dto.GetEntryResponse;
import br.com.pix.query_dict_api.domain.entries.Entry;
import br.com.pix.query_dict_api.service.EntryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static br.com.pix.query_dict_api.service.Constants.QUERYING_ENTRIES_BY_ACCOUNT;
import static br.com.pix.query_dict_api.service.Constants.QUERYING_KEY;

@RestController
@RequestMapping("/v1/entries")
@Tag(name = "Entries", description = "Operations related to entries by key")
@Slf4j
public class KeyController {

    private final EntryService entryService;

    public KeyController(final EntryService entryService) {
        this.entryService = entryService;
    }

    @Operation(summary = "Gets key information based on the provided key", description = "Returns a single document based on the provided key")
    @ApiResponse(responseCode = "200", description = "key information retrieved successfully", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Entry.class)))
    @GetMapping(path = "/{key}")
    public Optional<GetEntryResponse> getEntryByKey(@PathVariable final String key) throws Exception {
        log.info(QUERYING_KEY, key);
        return Optional.ofNullable(entryService.getEntryByKey(key));
    }

    @GetMapping(path = "/account")
    public List<GetEntryResponse> getEntryListByAccount(@RequestBody final AccountRequest accountRequest) throws Exception {
        log.info(QUERYING_ENTRIES_BY_ACCOUNT, accountRequest);
        return entryService.getEntriesByAccount(accountRequest);
    }
}
