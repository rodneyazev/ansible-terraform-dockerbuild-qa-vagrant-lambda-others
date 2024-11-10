package br.com.caelum.clines.api.flights;

import br.com.caelum.clines.shared.domain.Airport;
import br.com.caelum.clines.shared.domain.Country;
import br.com.caelum.clines.shared.domain.Location;
import br.com.caelum.clines.shared.domain.Waypoint;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.*;

class WaypointViewMapperTest {
    private static final Location GRU = new Location(Country.BR, "SP", "Guarulhos");
    private static final Airport DEFAULT_AIRPORT = new Airport("ASD123", GRU);
    private static final LocalDateTime DEFAULT_TIME = LocalDateTime.of(2020, Month.MAY, 28, 10, 30);
    private static final String DEFAULT_GATE = "23C";
    private static final Waypoint DEFAULT_WAYPOINT = new Waypoint(DEFAULT_AIRPORT, DEFAULT_TIME, DEFAULT_GATE);

    private WaypointViewMapper mapper = new WaypointViewMapper();

    @Test
    void shouldConvertWaypointToWaypointView() {

        var waypointView = mapper.map(DEFAULT_WAYPOINT);

        assertEquals(DEFAULT_AIRPORT.getCode(), waypointView.getCode());
        assertEquals(DEFAULT_GATE, waypointView.getGate());
        assertEquals(DEFAULT_TIME, waypointView.getTime());
    }
}