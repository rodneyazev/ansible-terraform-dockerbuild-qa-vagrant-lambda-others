package br.com.caelum.clines.api.aircraft;

import br.com.caelum.clines.shared.domain.Aircraft;
import br.com.caelum.clines.shared.domain.AircraftModel;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AircraftViewMapperTest {
    private static final AircraftModel BOEING_836 = new AircraftModel(1L, "Boeing 836");
    private static final String AIRCRAFT_CODE = "BCA213";

    private AircraftViewMapper mapper = new AircraftViewMapper();

    @Test
    void shouldConvertAircraftToAircraftView() {
        var aircraft = new Aircraft(AIRCRAFT_CODE, BOEING_836);

        var aircraftView = mapper.map(aircraft);

        assertEquals(AIRCRAFT_CODE, aircraftView.getCode());
        assertEquals(BOEING_836, aircraftView.getModel());
    }
}
