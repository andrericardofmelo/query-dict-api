package br.com.pix.query_dict_api.domain.statistics;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InfractionReports {
    private String watermark;
    private int openReports;
    private int openReportsDistinctReporters;
    private Settlements rejectedReports;
}
