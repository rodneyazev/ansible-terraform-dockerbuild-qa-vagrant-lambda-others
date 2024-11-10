package br.com.caelum.clines.api.aircraftmodels;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

import static org.springframework.http.ResponseEntity.created;

@RestController
@RequestMapping("aircraft-model")
@AllArgsConstructor
public class AircraftModelController {
    private final AircraftModelService service;

    @PostMapping
    ResponseEntity<?> createBy(@RequestBody @Valid AircraftModelForm form) {
        var id = service.createAircraftModelBy(form);

        var uri = URI.create("/aircraft-model/").resolve(String.valueOf(id));

        return created(uri).build();
    }
    
    @GetMapping
    List<AircraftModelView> list() {
        return service.listAllAircraftModels();
    }

    @GetMapping("{id}")
    AircraftModelView show(@PathVariable Long id) {
        return service.showAircraftModelBy(id);
    }
}
