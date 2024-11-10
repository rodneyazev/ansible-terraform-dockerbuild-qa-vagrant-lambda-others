package br.com.caelum.clines.api.promotionalcodes;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class PromotionalCodeForm {
    private String code;
    private LocalDate startDate;
    private LocalDate expirationDate;
    private String description;
    private Integer discount;
}
