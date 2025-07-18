package br.com.pix.query_dict_api.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    private String Participant;
    private String Branch;
    private String AccountNumber;
    private String AccountType;
    private LocalDate OpeningDate;
}
