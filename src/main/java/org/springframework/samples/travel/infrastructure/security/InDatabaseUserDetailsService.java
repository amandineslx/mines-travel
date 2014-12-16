package org.springframework.samples.travel.infrastructure.security;

import static com.google.common.collect.Sets.newHashSet;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import javax.inject.Inject;

import org.springframework.samples.travel.domain.model.user.User;
import org.springframework.samples.travel.domain.model.user.UserRepository;
import org.springframework.security.config.annotation.authentication.configurers.provisioning.UserDetailsManagerConfigurer.UserDetailsBuilder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class InDatabaseUserDetailsService implements UserDetailsService {

	private static final GrantedAuthority ROLE_SUPERVISOR = new SimpleGrantedAuthority(
			"ROLE_SUPERVISOR");
	private static final GrantedAuthority ROLE_USER = new SimpleGrantedAuthority(
			"ROLE_USER");

	private final UserRepository userRepository;

	@Inject
	public InDatabaseUserDetailsService(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
		manualUserImport();
	}

	public void manualUserImport(){
		User u1 = userRepository.findByUsername("test3");
		User admin = userRepository.findByUsername("admin");
		User user = userRepository.findByUsername("user");


		if(u1 == null){
			u1 = new User("test3", "8ad8757baa8564dc136c1e07507f4a98", "Test3");
			List<String> roles = new ArrayList<String>();
			roles.add("ROLE_USER");
			u1.setRoles(roles);
			userRepository.saveUser(u1);
		}

		if(admin == null){
			admin = new User("admin", "21232f297a57a5a743894a0e4a801fc3", "Admin");
			List<String> roles = new ArrayList<String>();
			roles.add("ROLE_SUPERVISOR");
			roles.add("ROLE_USER");
			admin.setRoles(roles);
			userRepository.saveUser(admin);
		}

		if(user == null){
			user = new User("user", "ee11cbb19052e40b07aac0ca060c23ee", "User");
			List<String> roles = new ArrayList<String>();
			roles.add("ROLE_USER");
			user.setRoles(roles);
			userRepository.saveUser(user);
		}
	}

	@Override
	public UserDetails loadUserByUsername(String arg0)
			throws UsernameNotFoundException {
		UserDetails userDetails = null;
		User user = userRepository.findByUsername(arg0);

		if (user != null){

			HashSet<GrantedAuthority> roles = new HashSet<GrantedAuthority>();
			if(user.getRoles().contains("ROLE_SUPERVISOR"))
				roles.add(ROLE_SUPERVISOR);
			if(user.getRoles().contains("ROLE_USER"))
				roles.add(ROLE_USER);


			userDetails = new org.springframework.security.core.userdetails.User(
					user.getUsername(), user.getPassword(), roles);

		}

		if (userDetails == null) {
			throw new UsernameNotFoundException("invalid username");
		}
		return userDetails;
	}

}
