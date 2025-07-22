package br.com.pix.query_dict_api.domain.entries;

import br.com.pix.query_dict_api.domain.statistics.KeyStatistics;
import br.com.pix.query_dict_api.domain.statistics.OwnerStatistics;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "entries")
@Schema(description = "Represents an entry in the dictionary with its response time, correlation ID, and entry details.")
public class Entries {
    @Id
    @Schema(description = "Unique identifier for the entry", example = "12345")
    private String id;
    @NotBlank
    @Schema(description = "Response time for the entry", example = "2020-01-10T10:00:00Z")
    private String responseTime;
    @NotBlank
    @Schema(description = "Unique identifier for the request", example = "123e4567-e89b-12d3-a456-426614174000")
    private String correlationId;
    @NotBlank
    @Schema(description = "Entry Collection", example = "Entry Collection Example")
    private Entry entry;
    private OwnerStatistics ownerStatistics;
    private KeyStatistics keyStatistics;
}
