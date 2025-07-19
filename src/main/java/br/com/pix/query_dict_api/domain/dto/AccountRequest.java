package br.com.pix.query_dict_api.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountRequest {
    private String Participant;
    private String Branch;
    private String AccountNumber;
}
