package br.com.caelum.clines.api.aircraft;

import br.com.caelum.clines.shared.domain.Aircraft;
import br.com.caelum.clines.shared.infra.Mapper;
import org.springframework.stereotype.Component;

@Component
public class AircraftViewMapper implements Mapper<Aircraft, AircraftView> {

    @Override
    public AircraftView map(Aircraft source) {
        var model = source.getModel();
        return new AircraftView(source.getCode(), model);
    }
}
