CREATE TABLE promotional_codes (
    id BIGSERIAL,
    code VARCHAR(10) NOT NULL,
    start_date DATE NOT NULL,
    expiration_date DATE NOT NULL,
    description VARCHAR(255) NOT NULL,
    discount INT NOT NULL,

    CONSTRAINT pk_promotional_codes PRIMARY KEY(id)
);
