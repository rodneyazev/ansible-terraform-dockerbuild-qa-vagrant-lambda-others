package br.com.caelum.clines.api.users;

import static java.util.stream.Collectors.toList;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.caelum.clines.shared.exceptions.ResourceAlreadyExistsException;
import br.com.caelum.clines.shared.exceptions.ResourceNotFoundException;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserService {

	private final UserRepository repository;
	private final UserViewMapper viewMapper;
	private final UserFormMapper formMapper;

	public List<UserView> findAll() {
		return repository.findAll().stream().map(viewMapper::map).collect(toList());
	}

	public UserView showUserBy(Long id) {
		return repository.findById(id).map(viewMapper::map)
				.orElseThrow(() -> new ResourceNotFoundException("Cannot find user"));
	}

	public Long createUserBy(UserForm form) {
		repository.findByEmail(form.getEmail()).ifPresent(user -> {
			throw new ResourceAlreadyExistsException("User already exists");
		});

		var user = formMapper.map(form);

		repository.save(user);

		return user.getId();
	}

}
