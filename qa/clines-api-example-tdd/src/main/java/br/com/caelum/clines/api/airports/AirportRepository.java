package br.com.caelum.clines.api.airports;

import br.com.caelum.clines.api.flights.ExistingAirportService;
import br.com.caelum.clines.shared.domain.Airport;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;

public interface AirportRepository extends Repository<Airport, String>, ExistingAirportService {
    List<Airport> findAll();

    Optional<Airport> findByCode(String code);

    void save(Airport airport);
}
