package br.com.pix.query_dict_api.controller;

import br.com.pix.query_dict_api.domain.dto.AccountRequest;
import br.com.pix.query_dict_api.domain.dto.GetEntryResponse;
import br.com.pix.query_dict_api.domain.entries.Entry;
import br.com.pix.query_dict_api.service.EntriesService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static br.com.pix.query_dict_api.infra.Constants.*;

@RestController
@RequestMapping("/v1/entries")
@Tag(name = "Entries", description = "Operations related to entries by key")
@Slf4j
public class EntriesController {

    private final EntriesService entriesService;

    public EntriesController(final EntriesService entriesService) {
        this.entriesService = entriesService;
    }

    @Operation(summary = "Gets key information based on the provided key", description = "Returns a single document based on the provided key")
    @ApiResponse(responseCode = "200", description = "key information retrieved successfully", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Entry.class)))
    @ApiResponse(responseCode = "404", description = "key not found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = GetEntryResponse.class)))
    @ApiResponse(responseCode = "400", description = "invalid key type", content = @Content(mediaType = "application/json", schema = @Schema(implementation = GetEntryResponse.class)))
    @ApiResponse(responseCode = "500", description = "internal server error", content = @Content(mediaType = "application/json", schema = @Schema(implementation = GetEntryResponse.class)))
    @GetMapping(path = "/{key}")
    public ResponseEntity<GetEntryResponse> getEntryByKey(@PathVariable final String key) {
        log.info(QUERYING_KEY, key);
        GetEntryResponse response = entriesService.getEntryByKey(key);
        return response != null ? ResponseEntity.ok(response) : ResponseEntity.notFound().build();
    }

    @GetMapping(path = "/account")
    public List<GetEntryResponse> getEntryListByAccount(@RequestBody final AccountRequest accountRequest) {
        log.info(QUERYING_ENTRIES_BY_ACCOUNT, accountRequest);
        return entriesService.getEntriesByAccount(accountRequest);
    }
}
