package br.com.caelum.clines.api.flights;


import br.com.caelum.clines.shared.domain.Aircraft;

import java.util.Optional;

public interface ExistingAircraftService {
    Optional<Aircraft> findByCode(String code);
}
