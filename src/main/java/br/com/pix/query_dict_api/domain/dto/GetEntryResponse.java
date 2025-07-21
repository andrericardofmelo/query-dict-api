package br.com.pix.query_dict_api.domain.dto;

import br.com.pix.query_dict_api.domain.entries.Entry;
import br.com.pix.query_dict_api.domain.statistics.KeyStatistics;
import br.com.pix.query_dict_api.domain.statistics.OwnerStatistics;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetEntryResponse {
    @Id
    private String id;
    @NotBlank
    private String responseTime;
    @NotBlank
    private String correlationId;
    @NotBlank
    private Entry entry;
    private OwnerStatistics ownerStatistics;
    private KeyStatistics keyStatistics;

}
