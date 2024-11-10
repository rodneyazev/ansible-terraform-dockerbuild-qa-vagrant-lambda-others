package br.com.caelum.clines.api.aircraft;

import br.com.caelum.clines.shared.domain.Aircraft;
import br.com.caelum.clines.shared.domain.AircraftModel;
import br.com.caelum.clines.shared.exceptions.ResourceNotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.only;

@ExtendWith(MockitoExtension.class)
class AircraftServiceTest {

    private static final String AIRCRAFT_CODE = "BX123D";
    private static final String NON_EXISTING_AIRCRAFT_CODE = "BAAC123";
    private static final AircraftModel AIRCRAFT_MODEL = new AircraftModel(1L, "Boeing 737");
    private static final Aircraft DEFAULT_AIRCRAFT = new Aircraft(AIRCRAFT_CODE, AIRCRAFT_MODEL);
    private static final List<Aircraft> ALL_AIRCRAFT = List.of(DEFAULT_AIRCRAFT);

    @Spy
    private AircraftFormMapper formMapper;

    @Spy
    private AircraftViewMapper viewMapper;

    @Mock
    private ExistingAircraftModelService modelService;

    @Mock
    private AircraftRepository repository;

    @InjectMocks
    private AircraftService service;

    @Test
    void shouldReturnSingleAnAircraftViewWhenExistingInRepository() {


        given(repository.findByCode(AIRCRAFT_CODE)).willReturn(Optional.of(DEFAULT_AIRCRAFT));

        var aircraftView = service.showAircraftBy(AIRCRAFT_CODE);

        then(repository).should(only()).findByCode(AIRCRAFT_CODE);
        then(viewMapper).should(only()).map(DEFAULT_AIRCRAFT);
        then(formMapper).shouldHaveNoInteractions();
        then(modelService).shouldHaveNoInteractions();

        assertEquals(AIRCRAFT_CODE, aircraftView.getCode());
        assertEquals(AIRCRAFT_MODEL, aircraftView.getModel());
    }

    @Test
    void shouldThrowExceptionWhenAircraftCodeNotExistingInRepository() {
        given(repository.findByCode(NON_EXISTING_AIRCRAFT_CODE)).willReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> service.showAircraftBy(NON_EXISTING_AIRCRAFT_CODE));

        then(repository).should(only()).findByCode(NON_EXISTING_AIRCRAFT_CODE);
        then(viewMapper).shouldHaveNoInteractions();
        then(formMapper).shouldHaveNoInteractions();
        then(modelService).shouldHaveNoInteractions();
    }

    @Test
    void shouldReturnAListOfAircraftViewForEachAircraftInRepository() {
        given(repository.findAll()).willReturn(ALL_AIRCRAFT);

        var allAircraftViews = service.listAllAircraft();

        then(repository).should(only()).findAll();
        then(viewMapper).should(only()).map(DEFAULT_AIRCRAFT);
        then(formMapper).shouldHaveNoInteractions();
        then(modelService).shouldHaveNoInteractions();

        assertEquals(ALL_AIRCRAFT.size(), allAircraftViews.size());

        var aircraftView = allAircraftViews.get(0);

        assertEquals(AIRCRAFT_CODE, aircraftView.getCode());
        assertEquals(AIRCRAFT_MODEL, aircraftView.getModel());
    }

    @Test
    void shouldReturnAnEmptyListWhenHasNoAircraftInRepository() {
        given(repository.findAll()).willReturn(List.of());

        var allAircraftViews = service.listAllAircraft();

        assertEquals(0, allAircraftViews.size());

        then(repository).should(only()).findAll();
        then(viewMapper).shouldHaveNoInteractions();
        then(formMapper).shouldHaveNoInteractions();
        then(modelService).shouldHaveNoInteractions();
    }
}
