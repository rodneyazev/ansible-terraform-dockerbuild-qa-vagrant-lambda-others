package br.com.caelum.clines.api.flights;

import br.com.caelum.clines.api.aircraft.AircraftViewMapper;
import br.com.caelum.clines.shared.domain.Flight;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class FlightViewFactory {

    private final WaypointViewMapper waypointViewMapper;
    private final AircraftViewMapper aircraftViewMapper;

    FlightView factory(Flight flight) {
        var departure = flight.getDeparture();
        var arrival = flight.getArrival();
        var aircraft = flight.getAircraft();

        var departureView = waypointViewMapper.map(departure);
        var arrivalView = waypointViewMapper.map(arrival);
        var aircraftView = aircraftViewMapper.map(aircraft);

        return new FlightView(flight.getId(), flight.getPrice(), departureView, arrivalView, aircraftView);
    }
}
