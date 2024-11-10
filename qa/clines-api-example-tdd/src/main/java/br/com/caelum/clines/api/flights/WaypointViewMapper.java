package br.com.caelum.clines.api.flights;

import br.com.caelum.clines.shared.domain.Waypoint;
import br.com.caelum.clines.shared.infra.Mapper;
import org.springframework.stereotype.Component;

@Component
public class WaypointViewMapper implements Mapper<Waypoint, WaypointView> {
    @Override
    public WaypointView map(Waypoint source) {
        return new WaypointView(source.getTime(), source.getAirport().getCode(), source.getGate());
    }
}
