package br.com.caelum.clines.api.flights;


import br.com.caelum.clines.shared.domain.Airport;

import java.util.Optional;

public interface ExistingAirportService {
    Optional<Airport> findByCode(String code);

    Optional<Airport> findById(Long id);
}
