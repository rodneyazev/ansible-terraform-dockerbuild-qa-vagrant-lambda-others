package br.com.caelum.clines.api.airports;

import br.com.caelum.clines.shared.domain.Airport;
import br.com.caelum.clines.shared.infra.Mapper;
import org.springframework.stereotype.Component;

import static br.com.caelum.clines.shared.util.StringNormalizer.normalize;


@Component
public class AirportFormMapper implements Mapper<AirportForm, Airport> {
    @Override
    public Airport map(AirportForm source) {
        var code = normalize(source.getCode());
        return new Airport(code, source.getLocation());
    }
}
