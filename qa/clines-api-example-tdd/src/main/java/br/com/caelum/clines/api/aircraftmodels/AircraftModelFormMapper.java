package br.com.caelum.clines.api.aircraftmodels;

import br.com.caelum.clines.shared.domain.AircraftModel;
import br.com.caelum.clines.shared.infra.Mapper;
import org.springframework.stereotype.Component;

@Component
public class AircraftModelFormMapper implements Mapper<AircraftModelForm, AircraftModel> {

    @Override
    public AircraftModel map(AircraftModelForm source) { return new AircraftModel(source.getDescription()); }
}
