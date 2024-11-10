package br.com.caelum.clines.api.aircraft;

import br.com.caelum.clines.shared.domain.Aircraft;
import br.com.caelum.clines.shared.infra.Mapper;
import org.springframework.stereotype.Component;

import static br.com.caelum.clines.shared.util.StringNormalizer.normalize;


@Component
public class AircraftFormMapper implements Mapper<AircraftForm, Aircraft> {

    @Override
    public Aircraft map(AircraftForm source) {
        return new Aircraft(normalize(source.getCode()), source.getModel());
    }
}
