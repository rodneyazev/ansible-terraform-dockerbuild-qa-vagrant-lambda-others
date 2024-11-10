package br.com.caelum.clines.api.flights;

import br.com.caelum.clines.api.locations.LocationView;
import br.com.caelum.clines.shared.exceptions.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@AllArgsConstructor
public class FlightService {


    private final FlightRepository repository;
    private final FlightViewFactory viewFactory;
    private final FlightFactory flightFactory;

    public FlightView showFlightBy(Long id) {
        return repository.findById(id).map(viewFactory::factory).orElseThrow(() -> new ResourceNotFoundException("Cannot find flight"));
    }

    public List<FlightView> listAllFlights() {
        return repository.findAll().stream().map(viewFactory::factory).collect(toList());
    }

    public Long createNewFlightBy(FlightForm form) {

        var flight = flightFactory.factory(form);

        repository.save(flight);

        return flight.getId();
    }

    public List<FlightView> searchBy(LocalDateTime date, LocationView location) {
        return repository.findAllBy(date, location.getCountry(), location.getState(), location.getCity())
                .stream()
                .map(viewFactory::factory)
                .collect(toList());
    }
}
