package com.database;

import com.airport.Flight;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.database.DatabaseUtil.buildFlightList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class StatisticsTest {

    // Allow us to call all the normal methods of the object
    @Spy
    private Database database;

    private List<List<String>> queriedData;
    private  List<Flight> flightList;

    @BeforeEach
    void before() {
        queriedData = new ArrayList<>();
        List<String> row1 = Arrays.asList("1", "e", "Mike", "false", "349");
        List<String> row2 = Arrays.asList("1", "b", "John", "true", "278");
        List<String> row3 = Arrays.asList("2", "e", "Mike", "false", "319");
        List<String> row4 = Arrays.asList("4", "p", "John", "true", "817");
        List<String> row5 = Arrays.asList("5", "e", "Mike", "false", "623");
        List<String> row6 = Arrays.asList("6", "e", "John", "true", "978");
        queriedData.add(row1);
        queriedData.add(row2);
        queriedData.add(row3);
        queriedData.add(row4);
        queriedData.add(row5);
        queriedData.add(row6);
    }

    @Test
    void testQueriedData() {
        when(database.queryFlightDatabase()).thenReturn(queriedData);
        flightList = buildFlightList(queriedData);
        assertEquals(6, database.queryFlightDatabase().size());
        assertEquals(6, flightList.size());
        assertEquals(560.666, database.averageDistance(flightList), 0.001);
        assertEquals(278, database.minimumDistance(flightList));
        assertEquals(978, database.maximumDistance(flightList));
    }
}
