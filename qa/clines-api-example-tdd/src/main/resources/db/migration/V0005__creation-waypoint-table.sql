CREATE TABLE waypoints (
    id BIGSERIAL,
    time TIMESTAMP NOT NULL,
    airport_id BIGINT NOT NULL,
    gate VARCHAR(30) NOT NULL,

    CONSTRAINT pk_waypoint PRIMARY KEY(id),
    CONSTRAINT fk_waypoint_to_airport FOREIGN KEY (airport_id) REFERENCES airports(id)
);

