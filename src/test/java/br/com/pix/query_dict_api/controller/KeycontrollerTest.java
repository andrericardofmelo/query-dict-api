package br.com.pix.query_dict_api.controller;


import br.com.pix.query_dict_api.domain.dto.GetEntryResponse;
import br.com.pix.query_dict_api.domain.entries.Entry;
import br.com.pix.query_dict_api.service.EntriesService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

class KeycontrollerTest {

    @Mock
    private EntriesService entryService;
    @InjectMocks
    private EntriesController entriesController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetEntryByKeySuccessful() {
        GetEntryResponse response = new GetEntryResponse();
        String key = "27529429078";
        response.setEntry(Entry.builder().key(key).build());
        when(entryService.getEntryByKey(key)).thenReturn(response);
        ResponseEntity<GetEntryResponse> responseEntity = entriesController.getEntryByKey(key);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(response, responseEntity.getBody());
    }

    @Test
    void testGetEntryByKeyNotFound() {
        ResponseEntity<GetEntryResponse> responseEntity = entriesController.getEntryByKey("27529429022");
        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
        assertNull(responseEntity.getBody());
    }
}
