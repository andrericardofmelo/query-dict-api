package br.com.pix.query_dict_api.controller;


import br.com.pix.query_dict_api.domain.dto.GetEntryResponse;
import br.com.pix.query_dict_api.domain.entries.Entry;
import br.com.pix.query_dict_api.exception.EntriesNotFoundException;
import br.com.pix.query_dict_api.service.EntryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

class KeycontrollerTest {

    @Mock
    private EntryService entryService;
    @Mock
    private GetEntryResponse getEntryResponse;
    @InjectMocks
    private KeyController keyController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetEntryByKeySuccessful() {
        GetEntryResponse expectedResponse = new GetEntryResponse();
        String key = "27529429078";
        expectedResponse.setEntry(Entry.builder().key(key).build());

        when(entryService.getEntryByKey(key)).thenReturn(expectedResponse);

        ResponseEntity<GetEntryResponse> responseEntity = keyController.getEntryByKey(key);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(expectedResponse, responseEntity.getBody());
    }

    @Test
    void testGetEntryByKeyNotFound() {
        assertThrows(EntriesNotFoundException.class, () -> {
            keyController.getEntryByKey("27529429022");
        });
    }
}
