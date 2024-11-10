package br.com.caelum.clines.api.flights;

import br.com.caelum.clines.shared.domain.Flight;
import br.com.caelum.clines.shared.exceptions.AircraftNotFoundException;
import br.com.caelum.clines.shared.exceptions.AirportNotFoundException;
import br.com.caelum.clines.shared.exceptions.ViolationException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
@AllArgsConstructor
public class FlightFactory {
    private final WaypointFormMapper waypointFormMapper;
    private final ExistingAircraftService aircraftService;
    private final ExistingAirportService airportService;

    Flight factory(FlightForm form) {
        var violations = new ArrayList<Exception>();

        populateAircraft(form, violations);
        populateWaypointForm(form.getDeparture(), violations, "Invalid Departure");
        populateWaypointForm(form.getArrival(), violations, "Invalid Arrival");

        if (!violations.isEmpty()) {
            throw new ViolationException(violations);
        }

        var departure = waypointFormMapper.map(form.getDeparture());
        var arrival = waypointFormMapper.map(form.getArrival());
        var aircraft = form.getAircraft();
        var price = form.getPrice();

        return new Flight(price, departure, arrival, aircraft);
    }

    private void populateAircraft(FlightForm form, ArrayList<Exception> violations) {
        aircraftService
                .findByCode(form.getAircraftId())
                .ifPresentOrElse(form::setAircraft, () -> violations.add(new AircraftNotFoundException("Invalid Aircraft")));
    }

    private void populateWaypointForm(WaypointForm form, ArrayList<Exception> violations, String message) {
        airportService
                .findById(form.getAirportId())
                .ifPresentOrElse(form::setAirport, () -> violations.add(new AirportNotFoundException(message)));
    }
}
