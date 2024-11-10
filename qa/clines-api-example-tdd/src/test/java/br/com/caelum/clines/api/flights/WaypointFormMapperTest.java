package br.com.caelum.clines.api.flights;

import br.com.caelum.clines.shared.domain.Airport;
import br.com.caelum.clines.shared.domain.Country;
import br.com.caelum.clines.shared.domain.Location;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.*;

class WaypointFormMapperTest {

    private static final Location GRU = new Location(Country.BR, "SP", "Guarulhos");
    private static final Airport DEFAULT_AIRPORT = new Airport("ASD123", GRU);
    private static final LocalDateTime DEFAULT_TIME = LocalDateTime.of(2020, Month.MAY, 28, 10, 30);
    private static final String DEFAULT_GATE = "23C";

    private WaypointFormMapper mapper = new WaypointFormMapper();

    @Test
    void shouldConvertWaypointFormToWaypoint() {
        var form = new WaypointForm();
        form.setAirport(DEFAULT_AIRPORT);
        form.setTime(DEFAULT_TIME);
        form.setGate(DEFAULT_GATE);

        var waypoint = mapper.map(form);

        assertEquals(DEFAULT_AIRPORT, waypoint.getAirport());
        assertEquals(DEFAULT_TIME, waypoint.getTime());
        assertEquals(DEFAULT_GATE, waypoint.getGate());
    }

}