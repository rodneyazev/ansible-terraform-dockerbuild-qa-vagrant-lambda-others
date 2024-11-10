package br.com.caelum.clines.api.aircraft;


import br.com.caelum.clines.shared.domain.AircraftModel;

import java.util.Optional;

public interface ExistingAircraftModelService {
    Optional<AircraftModel> findById(Long id);
}
