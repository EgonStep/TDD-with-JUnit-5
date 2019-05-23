package com.database;

import com.airport.Flight;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Database {

    private Map<String, String> registeredUsers = new HashMap<>();
    List<List<String>> queriedData = new ArrayList<>();

    public boolean login(Credentials credentials) {
        String username = credentials.getUsername();
        String password = credentials.getPassword();

        return registeredUsers.keySet().contains(username) &&
                registeredUsers.get(username).equals(password);
    }

    public List<List<String>> queryFlightDatabase() {
        return queriedData;
    }

    public double averageDistance(List<Flight> flightList) {
        return flightList.stream()
                .mapToDouble(Flight::getDistance)
                .average()
                .getAsDouble();
    }

    public int minimumDistance(List<Flight> flightList) {
        return flightList.stream()
                .mapToInt(Flight::getDistance)
                .min()
                .getAsInt();
    }

    public int maximumDistance(List<Flight> flightList) {
        return flightList.stream()
                .mapToInt(Flight::getDistance)
                .max()
                .getAsInt();
    }
}
