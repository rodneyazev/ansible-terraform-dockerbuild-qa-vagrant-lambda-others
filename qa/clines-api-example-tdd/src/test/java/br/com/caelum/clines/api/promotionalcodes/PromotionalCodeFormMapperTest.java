package br.com.caelum.clines.api.promotionalcodes;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class PromotionalCodeFormMapperTest {
    @Test
    void shouldReturnPromotionalCode() {
        var start = LocalDate.now();
        var expiration = LocalDate.now().plusMonths(1);

        var form = new PromotionalCodeForm("CODE", start, expiration, "DESCRIPTION", 10);

        var mapper = new PromotionalCodeFormMapper();

        var promotionalCode = mapper.map(form);

        assertThat(promotionalCode.getCode(), equalTo("CODE"));
        assertThat(promotionalCode.getStartDate(), equalTo(start));
        assertThat(promotionalCode.getExpirationDate(), equalTo(expiration));
        assertThat(promotionalCode.getDescription(), equalTo("DESCRIPTION"));
        assertThat(promotionalCode.getDiscount(), equalTo(10));
    }
}
