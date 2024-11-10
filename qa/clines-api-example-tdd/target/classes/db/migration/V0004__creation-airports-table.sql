CREATE TABLE airports (
    id BIGSERIAL,
    code VARCHAR(3) NOT NULL,
    location_id BIGINT NOT NULL,

    CONSTRAINT pk_airports PRIMARY KEY(id),
    CONSTRAINT fk_airports_to_location FOREIGN KEY (location_id) REFERENCES locations(id)
);


