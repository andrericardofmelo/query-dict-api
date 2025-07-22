package br.com.pix.query_dict_api.service;

import br.com.pix.query_dict_api.domain.entries.Entries;
import br.com.pix.query_dict_api.domain.entries.Entry;
import br.com.pix.query_dict_api.exception.EntriesNotFoundException;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertNull;

class EntriesHelperTest {

    private final EntriesHelper entriesHelper = new EntriesHelper();

    @Test
    void mountGetEntryResponse() {
        var entries = Entries.builder()
                .id("687ea82f1bc1c90f047f869d")
                .entry(Entry.builder().key("27529429078").build())
                .responseTime("2022-01-10T10:00:00Z")
                .correlationId("123e4567-e89b-12d3-a456-426614174000")
                .keyStatistics(null)
                .ownerStatistics(null)
                .build();
        var response = entriesHelper.mountGetEntryResponse(entries);
        assert response.getEntry().getKey().equals("27529429078");
        assertNull(response.getKeyStatistics());
    }

    @Test
    void mountGetEntryResponseEmpty() {
        assertThatThrownBy(() -> entriesHelper.mountGetEntryResponse(null))
                .isInstanceOf(EntriesNotFoundException.class)
                .hasMessage("Entries not found");
    }
}
