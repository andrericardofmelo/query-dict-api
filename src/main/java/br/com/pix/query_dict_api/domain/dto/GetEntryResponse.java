package br.com.pix.query_dict_api.domain.dto;

import br.com.pix.query_dict_api.domain.entries.Entry;
import br.com.pix.query_dict_api.domain.statistics.KeyStatistics;
import br.com.pix.query_dict_api.domain.statistics.OwnerStatistics;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetEntryResponse {
    private String responseTime;
    private String correlationId;
    private Entry entry;
    private OwnerStatistics ownerStatistics;
    private KeyStatistics keyStatistics;

}
