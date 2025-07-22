package br.com.pix.query_dict_api.domain.entries;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(description = "Details of a Pix key entry")
public class Entry {
    @Id
    @Schema(description = "unique id of entry", example = "60c72b2f9b1d8e001c8e4d2a")
    private String id;
    @Schema(description = "string <date-time>", example = "2020-01-10T10:00:00Z")
    private String responseTime;
    @Schema(description = "unique identifier for the request", example = "123e4567-e89b-12d3-a456-426614174000")
    private String correlationId;
    @NotBlank
    @Schema(description = "Pix key", example = "123e4567-e89b-12d3-a456-426614174000")
    @Size(min = 11, max = 77)
    private String key;
    @NotBlank
    @Schema(description = "Type of the Pix key", example = "CPF")
    private KeyType keyType;
    @NotEmpty
    @Schema(description = "Account details associated with the Pix key")
    private Account account;
    @NotEmpty
    @Schema(description = "Owner details of the Pix key")
    private Owner owner;
    @Schema(description = "Create of the Pix key", example = "2020-01-10T10:00:00Z")
    private String creationDate;
    @Schema(description = "Owner of the Pix key", example = "2020-01-10T10:00:00Z")
    private String keyOwnershipDate;
    @Schema(description = "Open Claim of the Pix key", example = "2020-01-10T10:00:00Z")
    private String openClaimCreationDate;
}
