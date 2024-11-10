CREATE TABLE aircraft_models (
    id BIGSERIAL,
    description VARCHAR(100) NOT NULL ,

    CONSTRAINT pk_aircraft_models PRIMARY KEY (id)
);