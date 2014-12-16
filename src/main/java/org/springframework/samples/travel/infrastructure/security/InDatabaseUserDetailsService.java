package org.springframework.samples.travel.infrastructure.security;

import static com.google.common.collect.Sets.newHashSet;

import javax.inject.Inject;

import org.springframework.samples.travel.domain.model.user.User;
import org.springframework.samples.travel.domain.model.user.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class InDatabaseUserDetailsService implements UserDetailsService {

	private static final SimpleGrantedAuthority ROLE_SUPERVISOR = new SimpleGrantedAuthority(
			"ROLE_SUPERVISOR");
	private static final GrantedAuthority ROLE_USER = new SimpleGrantedAuthority(
			"ROLE_USER");

	private final UserRepository userRepository;

	@Inject
	public InDatabaseUserDetailsService(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String arg0)
			throws UsernameNotFoundException {
		UserDetails userDetails = null;
		User user = userRepository.findByUsername(arg0);
		if (user != null)
			userDetails = new org.springframework.security.core.userdetails.User(
					user.getUsername(), user.getPassword(), newHashSet(
							ROLE_USER, ROLE_SUPERVISOR));

		if (userDetails == null) {
			throw new UsernameNotFoundException("invalid username");
		}
		return userDetails;
	}

}
