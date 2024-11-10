package br.com.caelum.clines.api.promotionalcodes;

import br.com.caelum.clines.shared.domain.PromotionalCode;
import br.com.caelum.clines.shared.exceptions.ResourceAlreadyExistsException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.*;
import static org.mockito.Mockito.only;

@ExtendWith(MockitoExtension.class)
public class PromotionalCodeServiceTest {
    @InjectMocks
    private PromotionalCodeService service;

    @Mock
    private PromotionalCodeRepository repository;

    @Spy
    private PromotionalCodeFormMapper formMapper;

    @Test
    void shouldCreateNewPromotionalCode() {
        var start = LocalDate.now();
        var expiration = LocalDate.now().plusMonths(1);

        var form = new PromotionalCodeForm("CODE", start, expiration, "DESCRIPTION", 10);
        var promotionalCode = new PromotionalCode(1L, "CODE", start, expiration, "DESCRIPTION", 10);

        given(repository.findByCode(any())).willReturn(Optional.empty());
        given(repository.save(any())).willReturn(promotionalCode);

        var code = service.createPromotionalCodeBy(form);

        then(repository).should().save(any());

        assertEquals("CODE", code);
    }

    @Test
    void shouldThrowResourceAlreadyExistsIfPromotionalCodeAlreadyExists() {
        var start = LocalDate.now();
        var expiration = LocalDate.now().plusMonths(1);

        var form = new PromotionalCodeForm("CODE", start, expiration, "DESCRIPTION", 10);
        var promotionalCode = new PromotionalCode(1L, "CODE", start, expiration, "DESCRIPTION", 10);

        given(repository.findByCode(any())).willReturn(Optional.of(promotionalCode));

        assertThrows(
                ResourceAlreadyExistsException.class,
                () -> service.createPromotionalCodeBy(form)
        );

        then(repository).should(only()).findByCode(any());
        then(repository).should(never()).save(any());
    }
}
