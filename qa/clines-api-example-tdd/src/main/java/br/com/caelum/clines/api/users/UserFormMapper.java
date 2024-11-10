package br.com.caelum.clines.api.users;

import org.springframework.stereotype.Component;

import br.com.caelum.clines.shared.domain.User;
import br.com.caelum.clines.shared.infra.Mapper;

@Component
public class UserFormMapper implements Mapper<UserForm, User> {

	@Override
	public User map(UserForm source) {
		return new User(source.getName(), source.getEmail(), source.getPassword());
	}

}
