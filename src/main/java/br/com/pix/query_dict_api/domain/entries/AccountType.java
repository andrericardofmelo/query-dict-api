package br.com.pix.query_dict_api.domain.entries;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
public enum AccountType {
    CACC("CACC"),
    TRAN("TRAN"),
    SLRY("SLRY"),
    SVGS("SVGS");

    private String accountTypeDescription;
}
