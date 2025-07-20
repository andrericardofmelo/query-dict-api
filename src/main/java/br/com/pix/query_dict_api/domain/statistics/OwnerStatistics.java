package br.com.pix.query_dict_api.domain.statistics;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OwnerStatistics {
    private Spi spi;
    @NotEmpty
    private FraudMarkers fraudMarkers;
    @NotEmpty
    private InfractionReports infractionReports;
    @NotEmpty
    private EntriesOwner entries;
}
