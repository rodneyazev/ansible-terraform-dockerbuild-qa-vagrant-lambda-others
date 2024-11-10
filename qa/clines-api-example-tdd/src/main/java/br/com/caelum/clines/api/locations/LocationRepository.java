package br.com.caelum.clines.api.locations;

import br.com.caelum.clines.api.airports.ExistingLocationService;
import br.com.caelum.clines.shared.domain.Location;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface LocationRepository extends Repository<Location, Long>, ExistingLocationService {
    void save(Location location);
    List<Location> findAll();
}
