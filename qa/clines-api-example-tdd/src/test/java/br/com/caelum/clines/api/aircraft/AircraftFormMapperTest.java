package br.com.caelum.clines.api.aircraft;

import br.com.caelum.clines.shared.domain.AircraftModel;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AircraftFormMapperTest {
    private static final Long EXISTING_MODEL_ID = 1L;
    private static final AircraftModel BOEING_836 = new AircraftModel(EXISTING_MODEL_ID, "Boeing 836");
    private static final String INPUT_AIRCRAFT_CODE = "bca123";
    private static final String EXPECTED_AIRCRAFT_CODE = "BCA123";

    private AircraftFormMapper mapper = new AircraftFormMapper();

    @Test
    void shouldConvertAircraftFormToAircraft() {
        var form = new AircraftForm(INPUT_AIRCRAFT_CODE, EXISTING_MODEL_ID);
        form.setModel(BOEING_836);

        var aircraft = mapper.map(form);

        assertEquals(EXPECTED_AIRCRAFT_CODE, aircraft.getCode());
        assertEquals(BOEING_836, aircraft.getModel());
    }
}
