package br.com.pix.query_dict_api.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Settlements {
    private int d90;
    private int m12;
    private int m60;
}
