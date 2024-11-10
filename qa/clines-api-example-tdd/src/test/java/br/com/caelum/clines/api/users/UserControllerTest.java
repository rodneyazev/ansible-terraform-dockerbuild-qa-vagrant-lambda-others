package br.com.caelum.clines.api.users;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;

import br.com.caelum.clines.shared.domain.User;

@SpringBootTest
@TestPropertySource(properties = { "DB_NAME=clines_test", "spring.jpa.hibernate.ddlAuto:create-drop" })
@AutoConfigureMockMvc
@AutoConfigureTestEntityManager
@Transactional
class UserControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private TestEntityManager entityManager;

	@Test
	void shouldReturn404WhenNotExistUserById() throws Exception {
		mockMvc.perform(get("/users/999")).andExpect(status().isNotFound());
	}

	@Test
	void shouldReturnAnUserById() throws Exception {
		var user = new User("Fulano", "fulano@email.com", "1234567");

		entityManager.persist(user);

		mockMvc.perform(get("/users/1")).andExpect(status().isOk())
			.andDo(log())
			.andExpect(jsonPath("$.name", equalTo(user.getName())))
			.andExpect(jsonPath("$.email", equalTo(user.getEmail())));
	}

}
