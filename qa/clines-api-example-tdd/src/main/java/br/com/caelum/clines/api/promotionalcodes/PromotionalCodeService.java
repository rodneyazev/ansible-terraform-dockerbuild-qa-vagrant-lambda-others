package br.com.caelum.clines.api.promotionalcodes;

import br.com.caelum.clines.shared.exceptions.ResourceAlreadyExistsException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PromotionalCodeService {
    private final PromotionalCodeRepository repository;
    private final PromotionalCodeFormMapper formMapper;

    public String createPromotionalCodeBy(PromotionalCodeForm form) {
        repository.findByCode(form.getCode()).ifPresent(entity -> {
            throw new ResourceAlreadyExistsException("Promotional code already exists");
        });

        var promotionalCode = formMapper.map(form);

        promotionalCode = repository.save(promotionalCode);

        return promotionalCode.getCode();
    }
}
