package br.com.caelum.clines.api.promotionalcodes;

import br.com.caelum.clines.shared.domain.PromotionalCode;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.time.LocalDate;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

@DataJpaTest
@TestPropertySource(properties = {"DB_NAME=clines_test", "spring.jpa.hibernate.ddlAuto:create-drop"})
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Transactional
class PromotionalCodeRepositoryTest {
    @Autowired
    private PromotionalCodeRepository repository;

    @Autowired
    private EntityManager entityManager;

    @Test
    void shouldSaveNewPromotionalCode() {
        var start = LocalDate.now();
        var expiration = LocalDate.now().plusMonths(1);

        var promotionalCode = new PromotionalCode("CODE", start, expiration, "DESCRIPTION", 10);

        assertNull(promotionalCode.getId());

        repository.save(promotionalCode);

        assertNotNull(promotionalCode.getId());

        var newObject = entityManager.find(
                PromotionalCode.class,
                promotionalCode.getId()
        );

        assertThat(newObject.getCode(), equalTo("CODE"));
        assertThat(newObject.getStartDate(), equalTo(start));
        assertThat(newObject.getExpirationDate(), equalTo(expiration));
        assertThat(newObject.getDescription(), equalTo("DESCRIPTION"));
        assertThat(newObject.getDiscount(), equalTo(10));
    }
}