package com.database;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DatabaseAccessTest {

    // Using mock object to simulate the database
    @Mock
    private Database database;

    private Credentials credentials = new Credentials("user", "password");

    @Test
    void testUserSuccessLogin() {
        when(database.login(credentials)).thenReturn(true);
        Credentials sameCredentials = new Credentials("user", "password");
        assertTrue(database.login(sameCredentials));
    }

    @Test
    @MockitoSettings(strictness = Strictness.LENIENT)
    void testUserFailedLogin() {
        when(database.login(credentials)).thenReturn(true);
        Credentials otherCredentials = new Credentials("user", "password");
        otherCredentials.setUsername("otherUser");
        otherCredentials.setPassword("otherPassword");
        assertNotEquals(credentials.getUsername(), otherCredentials.getUsername());
        assertNotEquals(credentials.getPassword(), otherCredentials.getPassword());
        assertNotEquals(credentials.hashCode(), otherCredentials.hashCode());
        assertFalse(database.login(otherCredentials));
    }
}
