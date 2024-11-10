package br.com.caelum.clines.api.aircraftmodels;

import br.com.caelum.clines.shared.domain.AircraftModel;
import br.com.caelum.clines.shared.infra.Mapper;
import org.springframework.stereotype.Component;

@Component
public class AircraftModelViewMapper implements Mapper<AircraftModel, AircraftModelView> {

    @Override
    public AircraftModelView map(AircraftModel source) {
        var id = source.getId();
        var description = source.getDescription();
        return new AircraftModelView(id, description);
    }
}
