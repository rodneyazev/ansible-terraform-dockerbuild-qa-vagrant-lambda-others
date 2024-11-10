package br.com.caelum.clines.api.aircraft;

import br.com.caelum.clines.shared.domain.AircraftModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
@NoArgsConstructor(access = AccessLevel.PACKAGE)
class AircraftForm {
    @JsonIgnore
    private AircraftModel model;

    @NotBlank
    private String code;

    @NotNull
    @Positive
    private Long modelId;

     AircraftForm(String code, Long modelId) {
        this.code = code;
        this.modelId = modelId;
    }
}
