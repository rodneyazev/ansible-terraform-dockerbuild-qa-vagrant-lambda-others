package br.com.caelum.clines.api.aircraftmodels;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AircraftModelFormMapperTest {
    private static final String INPUT_AIRCRAFT_MODEL_DESCRIPTION = "Boeing 836";
    private AircraftModelFormMapper mapper = new AircraftModelFormMapper();

    @Test
    void shoudlConvertAircraftModelFormToAircraftModel() {
        var form = new AircraftModelForm(INPUT_AIRCRAFT_MODEL_DESCRIPTION);

        var aircraftModel = mapper.map(form);

        assertEquals(INPUT_AIRCRAFT_MODEL_DESCRIPTION, aircraftModel.getDescription());
    }
}
