package br.com.pix.query_dict_api.controller;


import br.com.pix.query_dict_api.domain.dto.GetEntryResponse;
import br.com.pix.query_dict_api.service.EntryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class KeycontrollerTest {

    @Mock
    private EntryService entryService;
    @InjectMocks
    private KeyController keyController;

    @BeforeEach
    void setUp() {

        MockitoAnnotations.openMocks(this);
        keyController = new KeyController(entryService);
    }

    @Test
    void testGetEntryByKeySuccessful() {
        // Arrange
        String key = "27529429078";
        // Act
        ResponseEntity<GetEntryResponse> response = keyController.getEntryByKey(key);
        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }
    @Test
    void testGetEntryByKeyNotFound() {
        // Arrange
        String key = "27529429022";
        // Act
        ResponseEntity<GetEntryResponse> response = keyController.getEntryByKey(key);
        // Assert
        assertNotEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        }
}
