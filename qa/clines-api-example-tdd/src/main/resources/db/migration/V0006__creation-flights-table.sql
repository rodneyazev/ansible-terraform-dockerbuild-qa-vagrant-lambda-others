CREATE TABLE flights (
    id BIGSERIAL,
    price DECIMAL NOT NULL,
    aircraft_id BIGINT NOT NULL,
    departure_id BIGINT NOT NULL,
    arrival_id BIGINT NOT NULL,

    CONSTRAINT pk_flights PRIMARY KEY(id),
    CONSTRAINT fk_flights_to_aircraft FOREIGN KEY (aircraft_id) REFERENCES aircraft(id),
    CONSTRAINT fk_flights_departure_to_waypoint FOREIGN KEY (departure_id) REFERENCES waypoints(id),
    CONSTRAINT fk_flights_arrival_to_waypoint FOREIGN KEY (arrival_id) REFERENCES waypoints(id)
);

