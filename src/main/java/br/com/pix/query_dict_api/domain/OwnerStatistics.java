package br.com.pix.query_dict_api.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OwnerStatistics {
    private Spi spi;
    private FraudMarkers fraudMarkers;
    private InfractionReports infractionReports;
    private EntriesOwner entries;
}
