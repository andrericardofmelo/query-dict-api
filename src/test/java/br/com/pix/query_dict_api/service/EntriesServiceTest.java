package br.com.pix.query_dict_api.service;

import br.com.pix.query_dict_api.domain.dto.GetEntryResponse;
import br.com.pix.query_dict_api.domain.entries.*;
import br.com.pix.query_dict_api.exception.EntriesNotFoundException;
import br.com.pix.query_dict_api.repo.EntriesRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class EntriesServiceTest {

    @Mock
    private ValidationHelper validationHelper;

    @Mock
    private EntriesHelper entriesHelper;

    @Mock
    private EntriesRepository entriesRepository;

    @InjectMocks
    private EntriesService entriesService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetEntryByKey() {

        Entries newEntries = Entries.builder()
                .id("687ea82f1bc1c90f047f869d")
                .entry(Entry.builder()
                        .id("99c72b2f9b1d8e001c8e4d2a")
                        .key("27529429078")
                        .keyType(KeyType.CPF)
                        .account(Account.builder()
                                .openingDate(LocalDateTime.parse("2024-07-21 03:00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
                                .accountNumber("123456")
                                .accountType(AccountType.CACC)
                                .branch("0001")
                                .participant("12345678")
                                .build())
                        .owner(Owner.builder()
                                .name("Teste de Insert")
                                .taxIdNumber("27529429078")
                                .type(OwnerType.NATURAL_PERSON)
                                .build())
                        .build())
                .responseTime("2023-10-01T12:00:00Z")
                .correlationId("123e4567-e89b-12d3-a456-426614174000")
                .keyStatistics(null)
                .ownerStatistics(null)
                .build();
        when(validationHelper.validationKeyType(newEntries.getEntry().getKey())).thenReturn(KeyType.CPF);
        when(entriesRepository.findEntryByKey(newEntries.getEntry().getKey())).thenReturn(newEntries);
        when(entriesHelper.mountGetEntryResponse(any())).thenReturn(new GetEntryResponse());

    }

    @Test
    void testGetEntryByKeyWithInvalidKey() {
        String invalidKey = "invalidKey";
        when(validationHelper.validationKeyType(invalidKey)).thenThrow(new EntriesNotFoundException("The key cannot be null or empty."));
        assertThrows(EntriesNotFoundException.class, () -> entriesService.getEntryByKey(invalidKey));

    }

    @Test
    void testGetEntrytByKeyWithNonExistentKey() {
        String nonExistentKey = "99999999999";
        when(validationHelper.validationKeyType(nonExistentKey)).thenReturn(KeyType.CPF);
        when(entriesRepository.findEntryByKey(nonExistentKey)).thenReturn(null);
        when(entriesHelper.mountGetEntryResponse(null)).thenThrow(new EntriesNotFoundException("Entries not found."));
    }
}
