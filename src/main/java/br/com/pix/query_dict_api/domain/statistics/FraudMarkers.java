package br.com.pix.query_dict_api.domain.statistics;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FraudMarkers {
    private String watermark;

    private Settlements applicationFrauds;
    private Settlements muleAccounts;
    private Settlements scammerAccounts;
    private Settlements otherFrauds;
    private Settlements unknownFrauds;
    private Settlements totalFraudTransactionAmount;
    private Settlements distinctFraudReporters;
}
