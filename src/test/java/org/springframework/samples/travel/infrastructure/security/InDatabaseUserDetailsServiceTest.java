package org.springframework.samples.travel.infrastructure.security;

import static org.fest.assertions.Assertions.assertThat;

import java.rmi.UnexpectedException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.samples.travel.domain.model.user.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@RunWith(MockitoJUnitRunner.class)
public class InDatabaseUserDetailsServiceTest {

	@Mock
	private UserRepository userRepository;

	@InjectMocks
	private InDatabaseUserDetailsService service;

	@Test
	public void shouldFindUserTest() throws UnexpectedException {
		// Given
		String username = "test";
		if (service == null)
			throw new UnexpectedException("bouh");
		// When
		UserDetails details = service.loadUserByUsername(username);

		// Then
		assertThat(details.getUsername()).isEqualTo("test");
		// assertThat(details.getPassword()).isEqualTo("417c7382b16c395bc25b5da1398cf076");
		// assertThat(details.getAuthorities()).onProperty("authority").contains("ROLE_USER",
		// "ROLE_SUPERVISOR");
	}
	
	@Test
	public void shouldFindKeithUserName() throws UnexpectedException {
		// Given
		String username = "keith";
		if (service == null)
			throw new UnexpectedException("bouh");
		// When
		UserDetails details = service.loadUserByUsername(username);

		// Then
		assertThat(details.getUsername()).isEqualTo("keith");
		// assertThat(details.getPassword()).isEqualTo("417c7382b16c395bc25b5da1398cf076");
		// assertThat(details.getAuthorities()).onProperty("authority").contains("ROLE_USER",
		// "ROLE_SUPERVISOR");
	}

	@Test
	public void shouldFindErwinUserName() throws UnexpectedException {
		// Given

		String username = "erwin";

		// When
		UserDetails details = service.loadUserByUsername(username);

		// Then
		assertThat(details.getUsername()).isEqualTo("erwin");
		// assertThat(details.getPassword()).isEqualTo("12430911a8af075c6f41c6976af22b09");
		// assertThat(details.getAuthorities()).onProperty("authority").contains("ROLE_USER",
		// "ROLE_SUPERVISOR");
	}

	@Test
	public void shouldFindJeremyUserName() {
		// Given
		String username = "jeremy";

		// When
		UserDetails details = service.loadUserByUsername(username);

		// Then
		assertThat(details.getUsername()).isEqualTo("jeremy");
		// assertThat(details.getPassword()).isEqualTo("57c6cbff0d421449be820763f03139eb");
		// assertThat(details.getAuthorities()).onProperty("authority").contains("ROLE_USER");
	}

	@Test
	public void shouldFindScottUserName() {
		// Given
		String username = "scott";

		// When
		UserDetails details = service.loadUserByUsername(username);

		// Then
		assertThat(details.getUsername()).isEqualTo("scott");
		// assertThat(details.getPassword()).isEqualTo("942f2339bf50796de535a384f0d1af3e");
		// assertThat(details.getAuthorities()).onProperty("authority").contains("ROLE_USER");
	}

	@Test(expected = UsernameNotFoundException.class)
	public void shouldThrowExceptionIfUsernameNotFound() {
		// Given
		String username = "scotty";

		// When & Then
		service.loadUserByUsername(username);
	}

}
