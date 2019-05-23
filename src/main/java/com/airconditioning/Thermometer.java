package com.airconditioning;

public class Thermometer {

    private double temperature;
    private Sensor sensor;

    // The get temperature will work only if sensor is not blocked or else it need to throw a RunTimeException
    public double getTemperature() {
        if (sensor.isBlocked()) {
            throw new RuntimeException("Sensor is blocked");
        }
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public Sensor getSensor() {
        return sensor;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }
}
