package br.com.caelum.clines.api.promotionalcodes;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.net.URI;

import static org.springframework.http.ResponseEntity.created;

@RestController
@RequestMapping("promotional-code")
@AllArgsConstructor
public class PromotionalCodeController {
    private final PromotionalCodeService service;

    @PostMapping
    public ResponseEntity<?> createBy(@RequestBody @Valid PromotionalCodeForm form) {
        String code = service.createPromotionalCodeBy(form);

        URI uri = URI.create("/promotional-code/")
                .resolve(code);

        return created(uri).build();
    }
}
