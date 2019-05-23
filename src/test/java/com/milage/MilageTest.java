package com.milage;

import com.airport.Flight;
import com.airport.Passenger;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class MilageTest {

    private Milage milage;

    @BeforeAll
    void beforeAll() {
        milage = new Milage();
    }

    @ParameterizedTest
    @ValueSource(strings = {
            //Flight nº, type, name of passenger, isVip, distance
            "1; e; Mike; false; 349",
            "2; b; John; true; 278",
            "3; e; Mike; false; 319",
            "4; p; John; true; 817",
            "5; e; Mike; false; 623",
            "6; e; John; true; 978"
    })
    void checkGivenPoints(@ConvertWith(FlightArgumentConverter.class) Flight flight) {
        for(Passenger passenger : flight.getPassengers()){
            milage.addMilage(passenger, flight.getDistance());
        }
    }

    @AfterAll
    void afterAll() {
        milage.calculateGivenPoints();
        assertEquals(64, milage.getPassengersPointsMap().get(new Passenger("Mike", false)).intValue());
        assertEquals(207, milage.getPassengersPointsMap().get(new Passenger("John", true)).intValue());

        System.out.println(milage.getPassengersPointsMap());
    }
}