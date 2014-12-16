package org.springframework.samples.travel.infrastructure.persistence.mongo.user;

import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

import org.fest.assertions.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.samples.travel.domain.model.booking.Booking;
import org.springframework.samples.travel.domain.model.user.User;

@RunWith(MockitoJUnitRunner.class)
public class MongoUserRepositoryTest {

    @Mock
    private MongoTemplate mongoTemplate;
    @InjectMocks
    private MongoUserRepository repository;

    @Test
    public void souldFindUserByUsername() {
        // Given
        String username = "username";
        User user = new User();
        when(mongoTemplate.findOne(query(where("username").is(username)), User.class)).thenReturn(user);

        // When & then
        Assertions.assertThat(repository.findByUsername(username)).isSameAs(user);
    }

    @Test
    public void shouldCreateUser() {
        // Given
        String username = "username";
        String password = "password";
        String name = "name";
        
        User expectedUser = new User(username,password,name);

        // When
        User savedUser = repository.saveUser(expectedUser);

        // Then
        assertThat(savedUser).isSameAs(expectedUser);
        verify(mongoTemplate, times(1)).save(Mockito.same(expectedUser));
    }

    
  
    

}
