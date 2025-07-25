package br.com.pix.query_dict_api.domain.entries;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Account {
    @NotBlank
    @Pattern(regexp = "^\\d{8}$")
    private String participant;
    @NotBlank
    @Pattern(regexp = "^\\d{1,4}$")
    private String branch;
    @NotBlank
    @Pattern(regexp = "^\\d{1,20}$")
    private String accountNumber;
    @NotBlank
    @Pattern(regexp = "^[A-Z]{4}$")
    private AccountType accountType;
    @NotNull
    private LocalDateTime openingDate;
}
