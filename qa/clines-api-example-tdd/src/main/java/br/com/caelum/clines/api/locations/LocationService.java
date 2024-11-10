package br.com.caelum.clines.api.locations;

import br.com.caelum.clines.shared.domain.Country;
import br.com.caelum.clines.shared.exceptions.ResourceAlreadyExistsException;
import br.com.caelum.clines.shared.exceptions.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class LocationService {

    private final LocationRepository repository;
    private final LocationViewMapper viewMapper;
    private final LocationFormMapper formMapper;


    public Long createLocationBy(LocationForm form) {
        repository.findByCountryAndStateAndCity(Country.findByDescription(form.getCountry()), form.getState(), form.getCity())
                .ifPresent(existingLocation -> {
                    throw new ResourceAlreadyExistsException("Location already exists");
                });

        var location = formMapper.map(form);

        repository.save(location);

        return location.getId();
    }

    public List<LocationView> listAllLocations() {
        return repository.findAll().stream()
                .map(viewMapper::map)
                .collect(Collectors.toList());
    }

    public LocationView showLocationBy(Long id) {
        return repository.findById(id)
                .map(viewMapper::map)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Cannot find location")
                );
    }
}
