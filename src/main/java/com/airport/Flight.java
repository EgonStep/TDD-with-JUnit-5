package com.airport;

import java.util.*;

public abstract class Flight {

    private String id;
    private int distance;

    Set<Passenger> passengers = new HashSet<>();

    public Flight(String id) {
        this.id = id;
    }

    public String getId(){
        return id;
    }

    public Set<Passenger> getPassengers() {
        return Collections.unmodifiableSet(passengers);
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public abstract boolean addPassenger(Passenger passenger);

    public abstract boolean removePassenger(Passenger passenger);
}
