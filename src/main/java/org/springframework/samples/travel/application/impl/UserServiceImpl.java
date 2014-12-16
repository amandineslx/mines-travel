package org.springframework.samples.travel.application.impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.samples.travel.application.UserService;
import org.springframework.samples.travel.domain.model.user.User;
import org.springframework.samples.travel.domain.model.user.UserRepository;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

	@Inject
	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}


	@Override
	public User createUser(User user) {
		
		//encode password
		Md5PasswordEncoder encoder = new Md5PasswordEncoder();
		user.setPassword(encoder.encodePassword(user.getPassword(), null));
		
		//set user role
		List<String> roles = new ArrayList<String>();
		roles.add("ROLE_USER");
		user.setRoles(roles);
		
		return userRepository.saveUser(user);
	}
	
	@Override
	public User initUser() {
		return new User();
	}

}
