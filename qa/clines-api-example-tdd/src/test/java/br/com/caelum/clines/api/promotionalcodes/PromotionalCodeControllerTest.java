package br.com.caelum.clines.api.promotionalcodes;

import br.com.caelum.clines.shared.domain.PromotionalCode;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;

import javax.transaction.Transactional;
import java.time.LocalDate;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@TestPropertySource(properties = {"DB_NAME=clines_test", "spring.jpa.hibernate.ddlAuto:create-drop"})
@AutoConfigureMockMvc
@AutoConfigureTestEntityManager
@Transactional
public class PromotionalCodeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void shouldReturnHttpStatus201AndHeaderAttributeLocationWhenValidFormIsInformed() throws Exception {
        String promotionalCodeJson = "{ \"code\": \"B2CC71\", \"startDate\": \"2020-02-02\", \"expirationDate\": \"2020-03-03\", \"description\": \"Utilize este código promocional para ganhar 10% de desconto\", \"discount\": 10 }";

        mockMvc.perform(post("/promotional-code/").contentType(MediaType.APPLICATION_JSON).content(promotionalCodeJson))
                .andExpect(status().isCreated())
                .andExpect(header().exists("location"));
    }

    @Test
    public void shouldReturnHttpStatus409IfCodeAlreadyExists() throws Exception {
        var start = LocalDate.now();
        var expiration = LocalDate.now().plusMonths(1);
        var promotionalCode = new PromotionalCode("B2CC71", start, expiration, "DESCRIPTION", 10);
        entityManager.persist(promotionalCode);

        String promotionalCodeJson = "{ \"code\": \"B2CC71\", \"startDate\": \"2020-02-02\", \"expirationDate\": \"2020-03-03\", \"description\": \"Utilize este código promocional para ganhar 10% de desconto\", \"discount\": 10 }";

        mockMvc.perform(post("/promotional-code/").contentType(MediaType.APPLICATION_JSON).content(promotionalCodeJson))
                .andExpect(status().isConflict());
    }
}
