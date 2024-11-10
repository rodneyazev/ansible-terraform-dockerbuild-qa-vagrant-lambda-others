package br.com.caelum.clines.api.airports;

import br.com.caelum.clines.shared.domain.Airport;
import br.com.caelum.clines.shared.infra.Mapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class AirportViewMapper implements Mapper<Airport, AirportView> {

    private final AircraftLocationViewMapper aircraftLocationViewMapper;

    @Override
    public AirportView map(Airport source) {
        var locationView = aircraftLocationViewMapper.map(source.getLocation());

        return new AirportView(source.getCode(), locationView);
    }
}
