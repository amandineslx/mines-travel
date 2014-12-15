package org.springframework.samples.travel.application.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.samples.travel.domain.model.booking.Booking;
import org.springframework.samples.travel.domain.model.booking.BookingRepository;
import org.springframework.samples.travel.domain.model.booking.Hotel;
import org.springframework.samples.travel.domain.model.booking.HotelRepository;
import org.springframework.samples.travel.domain.model.user.User;
import org.springframework.samples.travel.domain.model.user.UserRepository;
import org.springframework.samples.travel.domain.shared.SearchCriteria;

import static com.google.common.collect.Lists.newArrayList;
import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplTest {
	
	@Mock
    private UserRepository userRepository;
	
    @InjectMocks
    private UserServiceImpl service;
    
    @Test
    public void shouldCreateUser(){
//        String username = "username";
//        String password = "password";
//        String name = "username";
//        
//        User expectedUser = new User(username, password, name);
//        
//     //  when(userRepository.saveUser(userToSave)).thenReturn(expectedUser);
//        
//        User user = service.createUser(username, password, name);
//        
//        assertThat(user).isSameAs(expectedUser);

    	
    }
    

}
