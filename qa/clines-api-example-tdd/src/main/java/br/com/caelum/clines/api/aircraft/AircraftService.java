package br.com.caelum.clines.api.aircraft;

import br.com.caelum.clines.shared.exceptions.AircraftModelNotFoundException;
import br.com.caelum.clines.shared.exceptions.ResourceAlreadyExistsException;
import br.com.caelum.clines.shared.exceptions.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@AllArgsConstructor
public class AircraftService {

    private final AircraftRepository repository;
    private final ExistingAircraftModelService modelService;
    private final AircraftViewMapper viewMapper;
    private final AircraftFormMapper formMapper;

    public AircraftView showAircraftBy(String code) {

        var aircraft = repository.findByCode(code).orElseThrow(() -> new ResourceNotFoundException("Cannot find aircraft"));

        return viewMapper.map(aircraft);
    }

    public List<AircraftView> listAllAircraft() {
        return repository.findAll().stream().map(viewMapper::map).collect(toList());
    }

    public String createAircraftBy(AircraftForm form) {
        repository.findByCode(form.getCode()).ifPresent(aircraft -> {
                throw new ResourceAlreadyExistsException("Aircraft already exists");
        });

        var model = modelService.findById(form.getModelId()).orElseThrow(() -> new AircraftModelNotFoundException("Cannot find aircraft model"));
        form.setModel(model);

        var aircraft = formMapper.map(form);

        repository.save(aircraft);

        return aircraft.getCode();
    }
}
