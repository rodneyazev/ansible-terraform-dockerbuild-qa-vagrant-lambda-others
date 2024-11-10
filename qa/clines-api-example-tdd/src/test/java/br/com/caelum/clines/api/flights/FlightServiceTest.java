package br.com.caelum.clines.api.flights;

import br.com.caelum.clines.api.aircraft.AircraftView;
import br.com.caelum.clines.api.locations.LocationView;
import br.com.caelum.clines.shared.domain.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class FlightServiceTest {

    @Mock
    private FlightViewFactory viewFactory;

    @Mock
    private FlightFactory flightFactory;

    @Mock
    private FlightRepository flightRepository;

    @InjectMocks
    private FlightService flightService;

    private final String DEFAULT_DATE = "01-05-2020";
    private final LocalDateTime DEFAULT_DATE_TIME = LocalDate.parse(DEFAULT_DATE, DateTimeFormatter.ofPattern("dd-MM-yyyy")).atStartOfDay();
    private final String DEFAULT_COUNTRY = "BR";
    private final String DEFAULT_STATE = "RJ";
    private final String DEFAULT_CITY = "Rio de Janeiro";
    private final LocationView DEFAULT_LOCATION = new LocationView(DEFAULT_COUNTRY, DEFAULT_STATE, DEFAULT_CITY);
    private final static Location DEFAULT_DEPARTURE_LOCATON = new Location(Country.BR, "São Paulo", "Guarulhos");

    @Test
    void shouldReturnEmptyListWhenNotFoundFlights() {
        given(flightRepository.findAllBy(DEFAULT_DATE_TIME, DEFAULT_COUNTRY, DEFAULT_STATE, DEFAULT_CITY)).willReturn(Collections.emptyList());
        List<FlightView> flights = flightService.searchBy(DEFAULT_DATE_TIME, DEFAULT_LOCATION);
        assertTrue(flights.isEmpty());
    }

    @Test
    void shouldReturnFlightWhenFoundFlights() {
        Flight defaultFlight = getDefaultFlight();

        given(flightRepository.findAllBy(DEFAULT_DATE_TIME, DEFAULT_COUNTRY, DEFAULT_STATE, DEFAULT_CITY)).willReturn(List.of(defaultFlight));
        given(viewFactory.factory(defaultFlight)).willReturn(getFlightView());
        List<FlightView> flights = flightService.searchBy(DEFAULT_DATE_TIME, DEFAULT_LOCATION);
        assertFalse(flights.isEmpty());
        assertEquals(1, flights.size());
        assertEquals(Long.valueOf(1), flights.get(0).getId());
        assertEquals(BigDecimal.TEN, flights.get(0).getPrice());
    }

    private Flight getDefaultFlight() {
        Airport DEFAULT_DEPARTURE_AIRPORT = new Airport("123", DEFAULT_DEPARTURE_LOCATON);

        LocalDateTime DEFAULT_DEPARTURE_DATETIME = LocalDateTime.now();

        Waypoint DEFAULT_DEPARTURE_WAYPOINT = new Waypoint(DEFAULT_DEPARTURE_AIRPORT, DEFAULT_DEPARTURE_DATETIME, "Gate 4");

        String DEFAULT_ARRIVAL_AIRPORT_CODE = "GIG";

        Location DEFAULT_ARRIVAL_LOCATON = new Location(Country.BR, "Rio de Janeiro", "Rio de Janeiro");

        Airport DEFAULT_ARRIVAL_AIRPORT = new Airport(DEFAULT_ARRIVAL_AIRPORT_CODE, DEFAULT_ARRIVAL_LOCATON);

        LocalDateTime DEFAULT_ARRIVAL_DATETIME = LocalDateTime.now();

        Waypoint DEFAULT_ARRIVAL_WAYPOINT = new Waypoint(DEFAULT_ARRIVAL_AIRPORT, DEFAULT_ARRIVAL_DATETIME, "Gate 4");

        AircraftModel DEFAULT_AIRCRAFT_MODEL = new AircraftModel(1L,"BOEING-777");

        Aircraft DEFAULT_AIRCRAFT = new Aircraft("777", DEFAULT_AIRCRAFT_MODEL);

        return new Flight(1L, BigDecimal.TEN, DEFAULT_DEPARTURE_WAYPOINT, DEFAULT_ARRIVAL_WAYPOINT, DEFAULT_AIRCRAFT);
    }
    private FlightView getFlightView() {
        WaypointView DEFAULT_WAYPOINT_DEPARTURE = new WaypointView(DEFAULT_DATE_TIME, "32B", "2");
        WaypointView DEFAULT_WAYPOINT_ARRIVAL = new WaypointView(DEFAULT_DATE_TIME, "40B", "1");
        AircraftModel DEFAULT_AIRCRAFT_MODEL = new AircraftModel("Boeing");
        AircraftView DEFAULT_AIRCRAFT_VIEW = new AircraftView("AB",DEFAULT_AIRCRAFT_MODEL );
        return new FlightView(1L, BigDecimal.TEN,DEFAULT_WAYPOINT_DEPARTURE, DEFAULT_WAYPOINT_ARRIVAL, DEFAULT_AIRCRAFT_VIEW);
    }
}