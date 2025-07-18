package br.com.pix.query_dict_api.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class KeyStatistics {
    private Spi spi;
    private FraudMarkers fraudMarkers;
    private InfractionReports infractionReports;
    private EntriesKey entries;
}
