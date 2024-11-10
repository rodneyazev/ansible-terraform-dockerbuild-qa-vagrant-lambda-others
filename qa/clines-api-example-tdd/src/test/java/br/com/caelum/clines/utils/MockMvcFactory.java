package br.com.caelum.clines.utils;

import br.com.caelum.clines.shared.infra.GlobalExceptionHandler;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

public final class MockMvcFactory {
    private MockMvcFactory() {
    }

    public static void configureMvcContextBy(Object controller) {
        var jacksonConverter = new MappingJackson2HttpMessageConverter();

        var mapper = new ObjectMapper()
        .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
        .registerModule(new JavaTimeModule());

        jacksonConverter.setObjectMapper(mapper);

        var mockMvc = standaloneSetup(controller)
                .setMessageConverters(jacksonConverter)
                .setControllerAdvice(new GlobalExceptionHandler());

        RestAssuredMockMvc.standaloneSetup(mockMvc);
    }

}
