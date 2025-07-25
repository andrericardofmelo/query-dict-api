package br.com.pix.query_dict_api.domain.statistics;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EntriesOwner {
    private String watermark;
    private int registeredAccounts;
}
