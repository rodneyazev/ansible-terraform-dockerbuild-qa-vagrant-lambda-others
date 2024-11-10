package br.com.caelum.clines.api.locations;

import br.com.caelum.clines.shared.domain.Country;
import br.com.caelum.clines.shared.domain.Location;
import br.com.caelum.clines.shared.infra.Mapper;
import org.springframework.stereotype.Component;

@Component
public class LocationFormMapper implements Mapper<LocationForm, Location> {

    @Override
    public Location map(LocationForm source) {
        var country = Country.findByDescription(source.getCountry());
        var state = source.getState();
        var city = source.getCity();

        return new Location(country, state, city);
    }
}
