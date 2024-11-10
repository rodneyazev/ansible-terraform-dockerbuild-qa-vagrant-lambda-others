package br.com.caelum.clines.api.locations;

import br.com.caelum.clines.shared.domain.Country;
import br.com.caelum.clines.shared.domain.Location;
import com.google.gson.Gson;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@TestPropertySource(properties = {"DB_NAME=clines_test","spring.jpa.hibernate.ddlAuto:create-drop"})
@AutoConfigureMockMvc
@AutoConfigureTestEntityManager
@Transactional
class LocationControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private TestEntityManager entityManager;

    private Gson gson = new Gson();

    @Test
    void shouldReturnLocationById() throws Exception {
        var location = new Location(Country.BR, "SP", "Poá");

        entityManager.persist(location);

        mockMvc.perform(get("/location/" + location.getId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.country", equalTo("Brazil")))
                .andExpect(jsonPath("$.state", equalTo("SP")))
                .andExpect(jsonPath("$.city", equalTo("Poá")));
    }

    @Test
    void shouldReturnNotFoundForNotFoundLocation() throws Exception {
        mockMvc.perform(get("/location/42"))
                .andExpect(status().isNotFound());
    }

    @Test
    public void shouldReturnHttpStatus201AndHeaderAttributeLocationWhenValidFormIsInformed() throws Exception {
        LocationForm locationForm = new LocationForm(Country.BR.getDescription(), "São Paulo", "Osasco");
        String locationJson = gson.toJson(locationForm);

        mockMvc.perform(post("/location/").contentType(MediaType.APPLICATION_JSON).content(locationJson))
                .andExpect(status().isCreated())
                .andExpect(header().exists("location"));
    }

    @Test
    public void listAllLocationsShouldReturnListOfLocations() throws Exception {
        Location location1 = new Location(Country.BR, "SP", "SAO PAULO");
        Location location2 = new Location(Country.BR, "SP", "CAMPINAS");

        entityManager.persist(location1);
        entityManager.persist(location2);

        LocationView locationView1 = new LocationView(location1.getId(), Country.BR.getDescription(), "SP", "SAO PAULO");
        LocationView locationView2 = new LocationView(location2.getId(), Country.BR.getDescription(), "SP", "CAMPINAS");
        List<LocationView> locations = List.of(locationView2, locationView1);

        mockMvc.perform(MockMvcRequestBuilders.get("/location"))
                .andExpect(status().isOk())
                .andExpect(
                        MockMvcResultMatchers.content()
                                .json(gson.toJson(locations))
                );
    }

    @Test
    public void listAllLocationsShouldReturnAnEmptyList() throws Exception {
        List<LocationView> locations = Collections.emptyList();

        mockMvc.perform(MockMvcRequestBuilders.get("/location"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content()
                        .json(gson.toJson(locations)));
    }
}