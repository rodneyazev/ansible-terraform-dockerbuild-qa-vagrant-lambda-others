package br.com.caelum.clines.shared.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "promotional_codes")
public class PromotionalCode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String code;

    @NotNull
    private LocalDate startDate;

    @NotNull
    private LocalDate expirationDate;

    @NotNull
    private String description;

    @NotNull
    private Integer discount;

    public PromotionalCode(String code, LocalDate startDate, LocalDate expirationDate, String description, int discount) {
        this.code = code;
        this.startDate = startDate;
        this.expirationDate = expirationDate;
        this.description = description;
        this.discount = discount;
    }
}
