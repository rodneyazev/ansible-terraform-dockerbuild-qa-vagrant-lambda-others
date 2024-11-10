package br.com.caelum.clines.api.airports;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AirportView {
    private String code;
    private AircraftLocationView location;
}
