package br.com.caelum.clines.api.airports;

import br.com.caelum.clines.shared.domain.Location;
import br.com.caelum.clines.shared.infra.Mapper;
import org.springframework.stereotype.Component;

@Component
public class AircraftLocationViewMapper implements Mapper<Location, AircraftLocationView> {
    @Override
    public AircraftLocationView map(Location source) {
        var country = source.getCountry();
        return new AircraftLocationView(country.getDescription(), source.getState(), source.getCity());
    }
}
