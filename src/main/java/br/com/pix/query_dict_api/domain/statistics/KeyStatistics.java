package br.com.pix.query_dict_api.domain.statistics;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class KeyStatistics {
    private Spi spi;
    private FraudMarkers fraudMarkers;
    @NotEmpty
    private InfractionReports infractionReports;
    @NotEmpty
    private EntriesKey entries;
}
