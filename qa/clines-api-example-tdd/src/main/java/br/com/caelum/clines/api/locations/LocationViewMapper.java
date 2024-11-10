package br.com.caelum.clines.api.locations;

import br.com.caelum.clines.shared.domain.Location;
import br.com.caelum.clines.shared.infra.Mapper;
import org.springframework.stereotype.Component;

@Component
public class LocationViewMapper implements Mapper<Location, LocationView> {
    @Override
    public LocationView map(Location source) {
        var country = source.getCountry();
        return new LocationView(source.getId(), country.getDescription(), source.getState(), source.getCity());
    }
}
