package br.com.caelum.clines.api.aircraftmodels;

import br.com.caelum.clines.shared.domain.AircraftModel;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AircraftModelViewMapperTest {

    private static final Long AIRCRAFT_CODE = 1l;
    private static final String AIRCRAFT_DESCRIPTION = "BOEING 767";

    private static final AircraftModel AIRCRAFT_MODEL = new AircraftModel(AIRCRAFT_CODE, AIRCRAFT_DESCRIPTION);

    private AircraftModelViewMapper mapper = new AircraftModelViewMapper();

    @Test
    void shouldConvertAircraftModelToAircrafModeltView() {
        var aircraftModel = new AircraftModel(AIRCRAFT_DESCRIPTION);

        var aircraftModelView = mapper.map(aircraftModel);

        assertEquals(AIRCRAFT_DESCRIPTION, aircraftModelView.getDescription());
    }

    @Test
    void shouldConvertAircraftModelToAircraftModelView() {
        var aircraftModelView = mapper.map(AIRCRAFT_MODEL);

        assertEquals(AIRCRAFT_CODE, aircraftModelView.getId());
        assertEquals(AIRCRAFT_DESCRIPTION, aircraftModelView.getDescription());
    }
}
