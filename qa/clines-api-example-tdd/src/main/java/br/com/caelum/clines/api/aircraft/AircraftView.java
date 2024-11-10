package br.com.caelum.clines.api.aircraft;

import br.com.caelum.clines.shared.domain.AircraftModel;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AircraftView {
    private String code;
    private AircraftModel model;
}
