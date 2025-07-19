package br.com.pix.query_dict_api.domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    @NotBlank
    @Pattern(regexp = "^[0-9]{8}$")
    private String Participant;
    @NotBlank
    @Pattern(regexp = "^[0-9]{1,4}$")
    private String Branch;
    @NotBlank
    @Pattern(regexp = "^[0-9]{1,20}$")
    private String AccountNumber;
    @NotBlank
    @Pattern(regexp = "^[A-Z]{4}$")
    private AccountType accountType;
    @NotNull
    private LocalDate OpeningDate;
}
