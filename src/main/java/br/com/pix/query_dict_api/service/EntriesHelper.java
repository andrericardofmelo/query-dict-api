package br.com.pix.query_dict_api.service;

import br.com.pix.query_dict_api.domain.dto.GetEntryResponse;
import br.com.pix.query_dict_api.domain.entries.Entries;
import br.com.pix.query_dict_api.exception.EntriesNotFoundException;
import org.springframework.stereotype.Component;

import static br.com.pix.query_dict_api.infra.Constants.ENTRIES_NOT_FOUND;

@Component
public class EntriesHelper {

    public GetEntryResponse mountGetEntryResponse(Entries entries) {
        if (entries == null) {
            throw new EntriesNotFoundException(ENTRIES_NOT_FOUND);
        }
        return GetEntryResponse.builder()
                .id(entries.getId())
                .entry(entries.getEntry())
                .responseTime(entries.getResponseTime())
                .correlationId(entries.getCorrelationId())
                .keyStatistics(entries.getKeyStatistics() == null ? null : entries.getKeyStatistics())
                .ownerStatistics(entries.getOwnerStatistics() == null ? null : entries.getOwnerStatistics())
                .build();
    }
}
