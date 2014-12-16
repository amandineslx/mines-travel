package org.springframework.samples.travel.application;

import org.springframework.samples.travel.domain.model.user.User;

public interface UserService {
	
	/**
     * Create a new user.
     * 
     * @param username
     *           
     * @param password
     * the unencrypted password
     * 
     * @param name
     * the name of the user
     */
	User createUser(User user);
	
	User initUser();

}
