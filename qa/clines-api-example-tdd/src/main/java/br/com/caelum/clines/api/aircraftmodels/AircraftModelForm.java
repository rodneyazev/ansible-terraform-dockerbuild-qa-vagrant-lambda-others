package br.com.caelum.clines.api.aircraftmodels;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor(access = AccessLevel.PACKAGE)
public class AircraftModelForm {
    @NotBlank
    private String description;

    AircraftModelForm(String description) {
       this.description = description;
    }
}
