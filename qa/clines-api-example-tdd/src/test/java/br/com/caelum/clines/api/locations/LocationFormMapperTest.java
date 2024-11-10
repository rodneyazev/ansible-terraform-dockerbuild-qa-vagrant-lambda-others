package br.com.caelum.clines.api.locations;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LocationFormMapperTest {
    private static final String INPUT_COUNTRY = "Brazil";
    private static final String INPUT_STATE = "São Paulo";
    private static final String INPUT_CITY = "São Paulo";
    private static final LocationForm form = new LocationForm(INPUT_COUNTRY, INPUT_STATE, INPUT_CITY);
    private static final LocationFormMapper mapper = new LocationFormMapper();

    @Test
    void shouldConvertLocationFormToLocation() {
        var location = mapper.map(form);

        assertEquals(INPUT_COUNTRY, location.getCountry().getDescription());
        assertEquals(INPUT_STATE, location.getState());
        assertEquals(INPUT_CITY, location.getCity());
    }
}
