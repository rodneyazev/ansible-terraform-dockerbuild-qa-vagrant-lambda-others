package br.com.caelum.clines.api.aircraft;

import br.com.caelum.clines.shared.domain.Aircraft;
import br.com.caelum.clines.shared.domain.AircraftModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.TestPropertySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

@DataJpaTest
@TestPropertySource(properties = {"DB_NAME=clines_test", "spring.jpa.hibernate.ddlAuto:create-drop"})
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class AircraftRepositoryTest {

    private static final String AIRCRAFT_CODE = "ASLDJ123";

    @Autowired
    private AircraftRepository repository;

    @Autowired
    private TestEntityManager entityManager;

    private AircraftModel BOEING;

    @BeforeEach
    void setup() {
        BOEING = new AircraftModel("Boeing 737 800");
        entityManager.persist(BOEING);
    }

    @Test
    void shouldReturnAircraftByCodeWhenExistsAnAircraftInDB() {
        var aircraft = new Aircraft(AIRCRAFT_CODE, BOEING);

        entityManager.persist(aircraft);

        var optionalAircraft = repository.findByCode(AIRCRAFT_CODE);

        assertThat(optionalAircraft).isPresent();

        var returnedAircraft = optionalAircraft.get();

        assertNotNull(returnedAircraft.getId());
        assertEquals(AIRCRAFT_CODE, returnedAircraft.getCode());
        assertEquals(BOEING, returnedAircraft.getModel());
    }

    @Test
    void shouldReturnAnEmptyOptionalWhenNotExistsAircraftByCode() {
        var optionalAircraft = repository.findByCode(AIRCRAFT_CODE);

        assertThat(optionalAircraft).isEmpty();
    }


    @Test
    void shouldSaveANewAircraft() {
        var aircraft = new Aircraft(AIRCRAFT_CODE, BOEING);

        assertNull(aircraft.getId());

        repository.save(aircraft);

        assertNotNull(aircraft.getId());

        assertEquals(AIRCRAFT_CODE, aircraft.getCode());
        assertEquals(BOEING, aircraft.getModel());
    }

}