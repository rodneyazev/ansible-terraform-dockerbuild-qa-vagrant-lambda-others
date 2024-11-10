package br.com.caelum.clines.api.flights;

import br.com.caelum.clines.shared.domain.Waypoint;
import br.com.caelum.clines.shared.infra.Mapper;
import org.springframework.stereotype.Component;

@Component
public class WaypointFormMapper implements Mapper<WaypointForm, Waypoint> {
    @Override
    public Waypoint map(WaypointForm source) {
        return new Waypoint(source.getAirport(), source.getTime(), source.getGate());
    }
}
